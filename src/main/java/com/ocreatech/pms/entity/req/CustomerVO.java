package com.ocreatech.pms.entity.req;

import java.time.LocalDate;

import lombok.Data;

/**
 * 客户信息
 * @author Daisy
 */
@Data
public class CustomerVO {
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String name;

}
