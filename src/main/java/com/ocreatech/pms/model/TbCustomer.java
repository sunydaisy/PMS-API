package com.ocreatech.pms.model;

import java.io.Serializable;
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
 * 客户信息表
 */
@Entity
@Table(name="tb_customer")
@Data
public class TbCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="business_name")
	private String businessName;

	@Column(name="business_type")
	private Integer businessType;

	@Column(name="charge_man")
	private String chargeMan;

	@Column(name="communicate_result")
	private String communicateResult;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="communicate_time")
	private LocalDateTime communicateTime;

	@Column(name="company_address")
	private String companyAddress;

	@Column(name="company_name")
	private String companyName;

	@Column(name="company_website")
	private String companyWebsite;

	@Column(name="company_website_desc")
	private String companyWebsiteDesc;

	@Column(name="contact_desc")
	private String contactDesc;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_phone")
	private String contactPhone;

	@Column(name="corporation_desc")
	private String corporationDesc;

	@Column(name="corporation_name")
	private String corporationName;

	@Column(name="corporation_phone")
	private String corporationPhone;

	@Column(name="creat_time")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime creatTime;

	@Column(name="cust_name")
	private String custName;

	@Column(name="cust_remark")
	private String custRemark;

	@Column(name="cust_status")
	private Integer custStatus;

	@Column(name="cust_status_name")
	private String custStatusName;

	@Column(name="is_communicat")
	private Boolean isCommunicat;
	
	@Column(name="del_flag")
	private Boolean delFlag;

	public TbCustomer() {
	}

}