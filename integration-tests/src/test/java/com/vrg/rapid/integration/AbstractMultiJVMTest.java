/*
 * Copyright © 2016 - 2017 VMware, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an “AS IS” BASIS, without warranties or conditions of any kind,
 * EITHER EXPRESS OR IMPLIED. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.vrg.rapid.integration;

import com.google.common.io.Files;
import com.vrg.standalone.StandaloneAgent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.write;

/**
 * AbstractMultiJVMTest for running rapid agents.
 */
public class AbstractMultiJVMTest {

    // Get Rapid StandAlone runner jar path.
    private static String RAPID_RUNNER_JAR =
            StandaloneAgent.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    // Interval to wait after shutdown retry
    private static final Long SHUTDOWN_RETRY_WAIT_MS = 500L;
    // Number of retries to kill node before giving up.
    private static final int SHUTDOWN_RETRIES = 10;
    // Timeout for a shutdown (millis)
    private static final int SHUTDOWN_TIMEOUT_MS = 5000;

    private static Set<RapidNodeRunner> rapidNodeRunners;

    AbstractMultiJVMTest() {
        rapidNodeRunners = new HashSet<>();
    }

    private static File OUTPUT_LOG_DIR;

    @Before
    public void setUp() {
        OUTPUT_LOG_DIR = Files.createTempDir();
        OUTPUT_LOG_DIR.deleteOnExit();
    }

    /**
     * Deletes temp output directory.
     * Cleans up all rapidNodeRunners.
     */
    @After
    public void cleanUp() {
        // remove if kill successful
        rapidNodeRunners.removeIf(rapidNodeRunner -> {
            if (rapidNodeRunner.killOnExit) {
                if (!rapidNodeRunner.isKilled) {
                    try {
                        return rapidNodeRunner.killNode();
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * Cleanup all runners.
     */
    @AfterClass
    public static void cleanUpEnv() {
        rapidNodeRunners.forEach(rapidNodeRunner -> {
            if (!rapidNodeRunner.isKilled) {
                try {
                    rapidNodeRunner.killNode();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * RapidNodeRunner
     * To manage and run rapid processes.
     */
    class RapidNodeRunner {

        private final String seed;
        private final String listenAddress;
        private final String role;
        private final String clusterName;

        private Process rapidProcess;

        private boolean isKilled = false;
        private boolean killOnExit = false;

        RapidNodeRunner(final String seed, final String listenAddress, final String role, final String clusterName) {
            this.seed = seed;
            this.listenAddress = listenAddress;
            this.role = role;
            this.clusterName = clusterName;
        }

        private class OutputLogger implements Runnable {
            private final InputStream inputStream;
            private final String logfile;

            private OutputLogger(final InputStream inputStream, final String logfile) {
                this.inputStream = inputStream;
                this.logfile = logfile;
            }

            @Override
            public void run() {
                try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,
                                                                                        Charset.defaultCharset()))) {
                    br.lines().forEach((x) -> {
                            try {
                                write(Paths.get(logfile), x.getBytes(Charset.defaultCharset()));
                            } catch (final IOException e) {
                                e.printStackTrace();
                            }
                        }
                    );
                } catch (final IOException e) {
                    e.printStackTrace();
                } catch (final UncheckedIOException ignored) {
                    // Thrown by br.lines() when a process is killed abruptly
                }
            }
        }

        /**
         * Runs the rapid process with the provided parameters.
         *
         * @return RapidNodeRunner
         * @throws IOException if jar or temp directory is not found.
         */
        RapidNodeRunner runNode() throws IOException {

            final File rapidRunnerJar = new File(RAPID_RUNNER_JAR);
            if (!rapidRunnerJar.exists()) {
                throw new FileNotFoundException("Rapid runner jar not found.");
            }
            final String command = "java" +
                    " -server" +
                    " -jar " + RAPID_RUNNER_JAR +
                    " --listenAddress " + this.listenAddress +
                    " --seedAddress " + this.seed +
                    " --role " + this.role +
                    " --cluster " + this.clusterName;
            final File outputLogFile = new File(OUTPUT_LOG_DIR + File.separator + UUID.randomUUID().toString());
            outputLogFile.deleteOnExit();
            System.out.println("Output for listenAddress:" +
                    listenAddress + " logged : " + outputLogFile.getAbsolutePath());

            final ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh", "-c", command);
            final Process rapidProcess = builder.start();
            final OutputLogger outputLogger =
                    new OutputLogger(rapidProcess.getInputStream(), outputLogFile.getAbsolutePath());
            Executors.newSingleThreadExecutor().execute(outputLogger);
            this.rapidProcess = rapidProcess;
            isKilled = false;
            rapidNodeRunners.add(this);

            return this;
        }

        /**
         * Returns the Rapid process
         */
        Process getRapidProcess() {
            return rapidProcess;
        }

        /**
         * Kills the process on test exit.
         *
         * @return
         */
        RapidNodeRunner killOnExit() {
            killOnExit = true;
            return this;
        }

        /**
         * Kills the process.
         *
         * @return true if kill successful else false.
         * @throws IOException          if I/O error occurs.
         * @throws InterruptedException if kill interrupted.
         */
        boolean killNode() throws IOException {

            Assert.assertNotNull(rapidProcess);
            long retries = SHUTDOWN_RETRIES;

            while (true) {

                try {
                    this.rapidProcess.destroyForcibly().waitFor(SHUTDOWN_TIMEOUT_MS, TimeUnit.MILLISECONDS);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }

                if (retries == 0) {
                    return false;
                }

                if (rapidProcess.isAlive()) {
                    retries--;
                    try {
                        Thread.sleep(SHUTDOWN_RETRY_WAIT_MS);
                    } catch (final InterruptedException ignored) {
                    }
                } else {
                    isKilled = true;
                    return true;
                }
            }
        }
    }
}
