package com.deva.kafka.admin.domains;

import java.util.List;

public class PartitionInfo {
    private int partionId;
    private NodeInfo leader;
    private List<NodeInfo> replicas;

    public PartitionInfo(int partionId, NodeInfo leader, List<NodeInfo> replicas) {
        this.partionId = partionId;
        this.leader = leader;
        this.replicas = replicas;
    }

    public int getPartionId() {
        return partionId;
    }

    public void setPartionId(int partionId) {
        this.partionId = partionId;
    }

    public NodeInfo getLeader() {
        return leader;
    }

    public void setLeader(NodeInfo leader) {
        this.leader = leader;
    }

    public List<NodeInfo> getReplicas() {
        return replicas;
    }

    public void setReplicas(List<NodeInfo> replicas) {
        this.replicas = replicas;
    }
}
