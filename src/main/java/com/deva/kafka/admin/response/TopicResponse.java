package com.deva.kafka.admin.response;

import java.util.List;

import com.deva.kafka.admin.domains.TopicInfo;

public class TopicResponse extends WebResponse{
    private List<TopicInfo> topicInfoList;

	public List<TopicInfo> getTopicInfoList() {
		return topicInfoList;
	}

	public void setTopicInfoList(List<TopicInfo> topicInfoList) {
		this.topicInfoList = topicInfoList;
	}    
}