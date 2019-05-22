package com.ocreatech.pms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * 项目信息表
 */
@Entity
@Table(name="tb_project_info")
@Data
public class TbProjectInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creat_time")
	private LocalDateTime creatTime;

	@Column(name="cust_contact_phone")
	private String custContactPhone;

	@Column(name="cust_name")
	private String custName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="exp_time")
	private LocalDate expTime;

	@Column(name="first_domain_name")
	private String firstDomainName;

	@Column(name="project_code")
	private String projectCode;

	@Column(name="project_name")
	private String projectName;

	@Column(name="project_remark")
	private String projectRemark;

	@Column(name="project_type")
	private Integer projectType;

	@Column(name="charge_man")
	private String chargeMan;

	@Column(name="second_domain_name")
	private String secondDomainName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="up_time")
	private LocalDate upTime;
	
	@Column(name="del_flag")
	private Boolean delFlag;

	public TbProjectInfo() {
	}

}