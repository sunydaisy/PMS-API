package com.ocreatech.pms.entity.req;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProjectAttrVO {
	
	@NotBlank(message="项目编码不能为空")
	private String projectCode;
	
	@NotBlank(message="项目属性编码不能为空")
	private Integer projectAttrCode;
	
	@NotBlank(message="项目属性名称不能为空")
	private String projectAttrName;
	
	private String projectAttrValue;

}
