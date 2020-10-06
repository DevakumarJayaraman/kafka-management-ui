package com.deva.kafka.admin.domains;

import java.util.ArrayList;
import java.util.List;

public class TopicInfo {
    private String topicName;
    private int partitionCount;
    private List<PartitionInfo> partitionInfoList= new ArrayList<>();

    public TopicInfo(String topicName, int partitionCount) {
        this.topicName = topicName;
        this.partitionCount = partitionCount;
    }

    public List<PartitionInfo> getPartitionInfoList() {
        return partitionInfoList;
    }

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public int getPartitionCount() {
		return partitionCount;
	}

	public void setPartitionCount(int partitionCount) {
		this.partitionCount = partitionCount;
	}
	
	public void addPartitionInfo(PartitionInfo partitionInfo){
        partitionInfoList.add(partitionInfo);
    }
}