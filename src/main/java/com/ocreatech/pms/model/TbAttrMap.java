package com.ocreatech.pms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * 项目字典表
 */
@Entity
@Table(name="tb_attr_map")
@Data
public class TbAttrMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="attr_code")
	private String attrCode;

	@Column(name="attr_name")
	private String attrName;

	@Column(name="attr_sort")
	private Integer attrSort;

	@Column(name="attr_type")
	private Integer attrType;

	@Column(name="attr_type_name")
	private String attrTypeName;

	public TbAttrMap() {
	}

}