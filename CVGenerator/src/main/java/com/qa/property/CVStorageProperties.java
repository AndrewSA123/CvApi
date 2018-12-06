package com.qa.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class CVStorageProperties {
	  private String uploadDir;

	    public String getUploadDir() {
	        return uploadDir;
	    }

	    public void setUploadDir(String uploadDir) {
	        this.uploadDir = uploadDir;
	    }
	}

