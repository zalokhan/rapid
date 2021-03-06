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

package com.vrg.rapid;

import com.google.common.net.HostAndPort;
import com.vrg.rapid.pb.LinkStatus;
import com.vrg.rapid.pb.Metadata;

/**
 * Represents a single node status change event. It is the format used to inform applications about
 * cluster view change events.
 */
public class NodeStatusChange {
    private final HostAndPort hostAndPort;
    private final LinkStatus status;
    private final Metadata metadata;

    NodeStatusChange(final HostAndPort hostAndPort,
                     final LinkStatus status,
                     final Metadata metadata) {
        this.hostAndPort = hostAndPort;
        this.status = status;
        this.metadata = metadata;
    }

    public HostAndPort getHostAndPort() {
        return hostAndPort;
    }

    public LinkStatus getStatus() {
        return status;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return String.valueOf(hostAndPort) + ":" + status + ":" + metadata;
    }
}