package com.deva.kafka.admin.response;

import com.deva.kafka.admin.domains.ConfigInfo;

public class ConfigResponse extends WebResponse{
    private ConfigInfo configInfo;

    public ConfigInfo getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(ConfigInfo configInfo) {
        this.configInfo = configInfo;
    }
}
