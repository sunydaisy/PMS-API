package com.ocreatech.pms.entity.resp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProjectRespVO {

	private Long id;

	private String companyName;

	private LocalDateTime creatTime;

	private String custContactPhone;

	private String custName;

	private String firstDomainName;

	private String projectCode;

	private String projectName;

	private String projectRemark;

	private Integer projectType;

	private String chargeMan;

	private String secondDomainName;

	private LocalDate upTime;
	
	private LocalDate expTime;
}
