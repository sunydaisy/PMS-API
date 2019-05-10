package com.ocreatech.pms.entity.basic;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserVO {
	@NotBlank(message="用户名不能为空")
	private String userName;
	@NotBlank(message="密码不能为空")
	private String passWord;

}
