package com.deva.kafka.admin.response;

import com.deva.kafka.admin.domains.TopicInfo;
import java.util.Map;

public class TopicResponse extends WebResponse{
    private Map<String, TopicInfo> topicInfoMap;

    public Map<String, TopicInfo> getTopicInfoMap() {
        return topicInfoMap;
    }

    public void setTopicInfoMap(Map<String, TopicInfo> topicInfoMap) {
        this.topicInfoMap = topicInfoMap;
    }
}
