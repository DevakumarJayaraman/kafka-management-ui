package com.deva.kafka.admin.response;

import com.deva.kafka.admin.domains.ConsumerGroupInfo;
import java.util.ArrayList;
import java.util.List;

public class GroupResponse extends WebResponse{
    private List<String> consumerGroups;
    private List<ConsumerGroupInfo> consumerGroupInfoList=new ArrayList<>();

    public List<String> getConsumerGroups() {
        return consumerGroups;
    }

    public void setConsumerGroups(List<String> consumerGroups) {
        this.consumerGroups = consumerGroups;
    }

    public List<ConsumerGroupInfo> getConsumerGroupInfoList() {
        return consumerGroupInfoList;
    }

    public void addConsumerGroupInfo(ConsumerGroupInfo consumerGroupInfo) {
        this.consumerGroupInfoList.add(consumerGroupInfo);
    }
}
