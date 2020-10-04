package com.deva.kafka.admin.domains;

public class GroupPartitionInfo {
    private String topicName;
    private int partitionId;
    private long currentOffset;
    private long endOffset;
    private long lag;
    private String consumerId;
    private String host;
    private String clientId;

    public GroupPartitionInfo(String topicName, int partitionId, long currentOffset) {
        this.topicName = topicName;
        this.partitionId = partitionId;
        this.currentOffset = currentOffset;
    }

    public GroupPartitionInfo(String topicName, int partitionId, long currentOffset, long endOffset, String consumerId, String host, String clientId) {
        this.topicName = topicName;
        this.partitionId = partitionId;
        this.currentOffset = currentOffset;
        this.endOffset = endOffset;
        this.lag = this.endOffset - this.currentOffset;
        this.consumerId = consumerId;
        this.host = host;
        this.clientId = clientId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(int partitionId) {
        this.partitionId = partitionId;
    }

    public long getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(int currentOffset) {
        this.currentOffset = currentOffset;
    }

    public long getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(long endOffset) {
        this.endOffset = endOffset;
    }

    public long getLag() {
        return lag;
    }

    public void setLag(long lag) {
        this.lag = lag;
    }
}
