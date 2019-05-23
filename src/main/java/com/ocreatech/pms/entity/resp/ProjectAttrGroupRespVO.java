package com.ocreatech.pms.entity.resp;

import java.util.List;

import lombok.Data;

@Data
public class ProjectAttrGroupRespVO {
	
	private Integer attrType;

	private String attrTypeName;
	
	private List<ProjectAttrRespVO> attrList;
	
}
