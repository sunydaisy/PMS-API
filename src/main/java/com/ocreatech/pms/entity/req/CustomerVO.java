package com.ocreatech.pms.entity.req;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.ocreatech.pms.entity.basic.PageRequestVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 客户信息
 * @author Daisy
 */
@Getter
@Setter
@ToString
public class CustomerVO extends PageRequestVO{
	
	private Long id;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String name;

	private String businessName;

	private Integer businessType;

	@NotBlank(message="负责人姓名不能为空")
	private String chargeMan;

	private String communicateResult;

	private LocalDateTime communicateTime;

	private String companyAddress;

	private String companyName;

	private String companyWebsite;

	private String companyWebsiteDesc;

	private String contactDesc;

	@NotBlank(message="联系人姓名不能为空")
	private String contactName;
	
	@NotBlank(message="联系人号码不能为空")
	private String contactPhone;

	private String corporationDesc;

	private String corporationName;

	private String corporationPhone;

	@NotBlank(message="客户姓名不能为空")
	private String custName;

	private String custRemark;

	private Integer custStatus;

	private String custStatusName;

	private Boolean isCommunicat;
	
}
