package com.deva.kafka.admin.response;

import com.deva.kafka.admin.domains.ClusterInfo;

public class ClusterResponse extends WebResponse {
    private ClusterInfo clusterInfo;

    public ClusterInfo getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(ClusterInfo clusterInfo) {
        this.clusterInfo = clusterInfo;
    }
}
