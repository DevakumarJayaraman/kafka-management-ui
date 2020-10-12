package com.deva.kafka.admin.domains;

import java.util.HashMap;
import java.util.Map;

public class ConfigInfo {
	
	private String resourceType;
	private String resourceName;
	
    public ConfigInfo(String resourceType, String resourceName) {
		super();
		this.resourceType = resourceType;
		this.resourceName = resourceName;
	}

	private Map<String, String> configMap = new HashMap<>();

    public Map<String, String> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, String> configMap) {
        this.configMap = configMap;
    }

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
