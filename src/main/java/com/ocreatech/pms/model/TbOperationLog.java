package com.ocreatech.pms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * 操作日志
 */
@Entity
@Table(name="tb_operation_logs")
@Data
public class TbOperationLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="operation_method")
	private String operationMethod;

	@Column(name="operation_name")
	private String operationName;

	@Lob
	@Column(name="operation_requst")
	private String operationRequst;

	@Column(name="operation_response")
	private String operationResponse;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="operation_time")
	private LocalDateTime operationTime;

	@Column(name="operation_url")
	private String operationUrl;

	@Column(name="operation_user")
	private String operationUser;

}