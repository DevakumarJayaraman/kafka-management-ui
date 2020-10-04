package com.deva.kafka.admin.domains;

public class NodeInfo {
    private String nodeId;
    private String address;

    public NodeInfo(String nodeId, String address) {
        this.nodeId = nodeId;
        this.address = address;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
