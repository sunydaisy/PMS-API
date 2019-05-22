package com.ocreatech.pms.entity.resp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.ocreatech.pms.model.TbProjectAttr;

import lombok.Data;

@Data
public class ProjectDetailRespVO {

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
	 
	private List<TbProjectAttr> projectAttrs;
}
