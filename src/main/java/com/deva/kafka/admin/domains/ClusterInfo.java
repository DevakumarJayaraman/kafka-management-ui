package com.deva.kafka.admin.domains;

import java.util.List;

public class ClusterInfo {
    private String clusterId;
    private List<NodeInfo> nodeInfoList;

    public ClusterInfo(String clusterId, List<NodeInfo> nodeInfoList) {
        this.clusterId = clusterId;
        this.nodeInfoList = nodeInfoList;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public List<NodeInfo> getNodeInfoList() {
        return nodeInfoList;
    }

    public void setNodeInfoList(List<NodeInfo> nodeInfoList) {
        this.nodeInfoList = nodeInfoList;
    }
}
