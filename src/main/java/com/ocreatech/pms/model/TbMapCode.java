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
 * 字典表
 */
@Entity
@Table(name="tb_map_code")
@Data
public class TbMapCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="table_name")
	private String tableName;

	@Column(name="column_name")
	private String columnName;

	@Column(name="type_code")
	private Integer typeCode;

	@Column(name="code_name")
	private Integer codeName;

	public TbMapCode() {
	}

}