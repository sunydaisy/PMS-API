package com.ocreatech.pms.entity.req;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AttrMapVO {
	
	private Long id;

	@NotBlank(message="属性编码不能为空")
	private Integer attrCode;

	@NotBlank(message="属性名称不能为空")
	private String attrName;

	@NotBlank(message="属性排序不能为空")
	private Integer attrSort;
	
	@NotBlank(message="属性类型不能为空")
	private Integer attrType;

	@NotBlank(message="属性类型名称不能为空")
	private String attrTypeName;
}
