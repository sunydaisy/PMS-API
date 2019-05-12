package com.ocreatech.pms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.req.CustomerVO;
import com.ocreatech.pms.service.CustomerSerivce;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	private CustomerSerivce service;
	
	@PostMapping("/list")
	public ResponseDataVO<Object> list(@RequestBody CustomerVO params){
		return ResponseDataVO.success(service.listCust(params));
	}

}
