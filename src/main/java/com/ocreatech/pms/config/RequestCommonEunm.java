package com.ocreatech.pms.config;

public enum RequestCommonEunm {
	ACCESS_TOKEN("Access-Token"),
	ENCODING_UTF8("UTF-8"),
	CONTENT_TYPE_JSON("application/json; charset=utf-8")
	;
	
	private String key;
	
	private RequestCommonEunm(String key) {
		this.key = key;
	}
	
	public String key() {
		return this.key;
	}

}
