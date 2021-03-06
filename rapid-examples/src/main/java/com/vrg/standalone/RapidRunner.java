package com.vrg.standalone;

import com.google.common.net.HostAndPort;
import com.google.protobuf.ByteString;
import com.vrg.rapid.Cluster;
import com.vrg.rapid.NodeStatusChange;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Brings up Rapid Cluster instances.
 */
class RapidRunner {
    @Nullable private static final Logger NETTY_LOGGER;
    @Nullable private static final Logger GRPC_LOGGER;
    private final Cluster cluster;
    private final HostAndPort listenAddress;

    static {
        GRPC_LOGGER = Logger.getLogger("io.grpc");
        GRPC_LOGGER.setLevel(Level.WARNING);
        NETTY_LOGGER = Logger.getLogger("io.grpc.netty.NettyServerHandler");
        NETTY_LOGGER.setLevel(Level.OFF);
    }

    RapidRunner(final HostAndPort listenAddress, final HostAndPort seedAddress,
                final String role, final int sleepDelayMsForNonSeed)
            throws IOException, InterruptedException {
        this.listenAddress = listenAddress;
        if (listenAddress.equals(seedAddress)) {
            cluster = new Cluster.Builder(listenAddress)
                                 .setMetadata(Collections.singletonMap("role",
                                         ByteString.copyFrom(role, Charset.defaultCharset())))
                                 .start();

        } else {
            Thread.sleep(sleepDelayMsForNonSeed);
            cluster = new Cluster.Builder(listenAddress)
                                 .setMetadata(Collections.singletonMap("role",
                                         ByteString.copyFrom(role, Charset.defaultCharset())))
                                 .join(seedAddress);
        }
        cluster.registerSubscription(com.vrg.rapid.ClusterEvents.VIEW_CHANGE_PROPOSAL,
                this::onViewChangeProposal);
        cluster.registerSubscription(com.vrg.rapid.ClusterEvents.VIEW_CHANGE,
                this::onViewChange);
        cluster.registerSubscription(com.vrg.rapid.ClusterEvents.VIEW_CHANGE_ONE_STEP_FAILED,
                this::onViewChangeOneStepFailed);
        cluster.registerSubscription(com.vrg.rapid.ClusterEvents.KICKED,
                this::onKicked);
    }

    /**
     * Executed whenever a Cluster VIEW_CHANGE_PROPOSAL event occurs.
     */
    private void onViewChangeProposal(final List<NodeStatusChange> viewChange) {
        System.out.println("The condition detector has outputted a proposal: " + viewChange);
    }

    /**
     * Executed whenever a Cluster VIEW_CHANGE_ONE_STEP_FAILED event occurs.
     */
    private void onViewChangeOneStepFailed(final List<NodeStatusChange> viewChange) {
        System.out.println("The condition detector had a conflict during one-step consensus: " + viewChange);
    }

    /**
     * Executed whenever a Cluster KICKED event occurs.
     */
    private void onKicked(final List<NodeStatusChange> viewChange) {
        System.out.println("We got kicked from the network: " + viewChange);
    }

    /**
     * Executed whenever a Cluster VIEW_CHANGE event occurs.
     */
    private void onViewChange(final List<NodeStatusChange> viewChange) {
        System.out.println("View change detected: " + viewChange);
    }

    /**
     * Wait inside a loop
     */
    void run(final int maxTries, final int sleepIntervalMs) throws InterruptedException {
        int tries = maxTries;
        while (tries-- > 0) {
            System.out.println(System.currentTimeMillis() + " " + listenAddress +
                    " Cluster size " + cluster.getMembershipSize() + " " + tries);
            Thread.sleep(sleepIntervalMs);
        }
    }

    String getClusterStatus() {
        return System.currentTimeMillis() + " " + listenAddress + " Cluster size " + cluster.getMembershipSize();
    }
}
