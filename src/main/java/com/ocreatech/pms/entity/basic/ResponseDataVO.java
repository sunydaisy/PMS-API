package com.ocreatech.pms.entity.basic;

import lombok.Data;

@Data
public class ResponseDataVO<T> {
	
	private Boolean success;
	
	private Integer status;
	
	private String msg;
	
	private T data;

}
