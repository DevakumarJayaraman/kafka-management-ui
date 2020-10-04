package com.deva.kafka.admin.domains;

import java.util.ArrayList;
import java.util.List;

public class ConsumerGroupInfo {
    private String groupId;
    private List<GroupPartitionInfo> groupPartitions=new ArrayList<>();

    public ConsumerGroupInfo(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<GroupPartitionInfo> getGroupPartitions() {
        return groupPartitions;
    }

    public void addGroupPartitionInfo(GroupPartitionInfo groupPartitionInfo) {
        this.groupPartitions.add(groupPartitionInfo);
    }
}
