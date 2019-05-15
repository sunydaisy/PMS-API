package com.ocreatech.pms.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.req.UserVO;
import com.ocreatech.pms.service.SysUserService;
import com.ocreatech.pms.utils.ValidUtil;

@RestController
@RequestMapping("/user")
public class SysUserController {
	
	@Autowired
	private SysUserService service;
	
	@PostMapping("/login")
	public ResponseDataVO<Object> login(@Valid @RequestBody UserVO user,BindingResult result) {
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return service.login(user);
	}

}
