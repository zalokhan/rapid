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
import com.vrg.rapid.pb.Status;

import java.util.Objects;

/**
 * LinkUpdateMessage is used by nodes to announce changes in link status
 *
 * XXX: This class is redundant given the one generated by protobufs
 */
final class LinkUpdateMessage {
    private final HostAndPort src;
    private final HostAndPort dst;
    private final Status status;

    LinkUpdateMessage(final HostAndPort src,
                      final HostAndPort dst,
                      final Status status) {
        this.src = Objects.requireNonNull(src);
        this.dst = Objects.requireNonNull(dst);
        this.status = Objects.requireNonNull(status);
    }

    LinkUpdateMessage(final String src,
                      final String dst,
                      final Status status) {
        this.src = HostAndPort.fromString(Objects.requireNonNull(src));
        this.dst = HostAndPort.fromString(Objects.requireNonNull(dst));
        this.status = Objects.requireNonNull(status);
    }

    HostAndPort getSrc() {
        return src;
    }

    HostAndPort getDst() {
        return dst;
    }

    Status getStatus() {
        return status;
    }
}