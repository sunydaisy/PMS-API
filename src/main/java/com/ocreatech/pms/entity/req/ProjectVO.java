package com.ocreatech.pms.entity.req;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ocreatech.pms.entity.basic.PageRequestVO;
import com.ocreatech.pms.model.TbProjectAttr;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjectVO extends PageRequestVO{
	
	private LocalDate createStartTime;
	
	private LocalDate createEndTime;
	
	private String name;
	
	private Long id;
	
	@NotBlank(message="项目编码不能为空")
	private String projectCode;
	
	@NotBlank(message="项目名称不能为空")
	private String projectName;

	@NotBlank(message="客户名称不能为空")
	private String custName;
	
	@NotBlank(message="客户联系方式不能为空")
	private String custContactPhone;
	
	@NotBlank(message="负责人不能为空")
	private String chargeMan;
	
	private String companyName;

	private LocalDateTime creatTime;

	private String firstDomainName;

	private String projectRemark;

	private Integer projectType;

	private String secondDomainName;

	private LocalDate upTime;
	
	private LocalDate expTime;
	
	private List<TbProjectAttr> projectAttrs;

}
