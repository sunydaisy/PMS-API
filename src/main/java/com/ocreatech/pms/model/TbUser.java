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
 * 系统用户表
 */
@Entity
@Table(name="tb_user")
@Data
public class TbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="acess_token")
	private String acessToken;

	@Column(name="pass_word")
	private String passWord;

	@Column(name="user_mark")
	private String userMark;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_code")
	private String userCode;

	@Column(name="user_type")
	private Integer userType;

	public TbUser() {
	}

}