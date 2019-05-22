package com.ocreatech.pms.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * 项目属性表
 */
@Entity
@Table(name="tb_project_attr")
@Data
public class TbProjectAttr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="project_attr_code")
	private Integer projectAttrCode;

	@Column(name="project_attr_name")
	private String projectAttrName;

	@Column(name="project_attr_value")
	private String projectAttrValue;

	@Column(name="project_code")
	private String projectCode;

	public TbProjectAttr() {
	}

}