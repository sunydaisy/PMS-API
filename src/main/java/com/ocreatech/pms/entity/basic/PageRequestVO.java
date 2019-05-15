package com.ocreatech.pms.entity.basic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageRequestVO {
	
	private Integer pageNum;
	
	private Integer pageSize;
	
	public PageRequestVO pageRequset() {
		return this;
	}

}
