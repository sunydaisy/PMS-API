package com.ocreatech.pms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocreatech.pms.annotation.OperationLog;
import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.basic.ResponsePageVO;
import com.ocreatech.pms.entity.basic.ResponseStatus;
import com.ocreatech.pms.entity.req.CustomerVO;
import com.ocreatech.pms.model.TbCustomer;
import com.ocreatech.pms.service.CustomerSerivce;
import com.ocreatech.pms.utils.ValidUtil;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerSerivce service;
	
	@PostMapping("/list")
	@OperationLog(name="查询客户列表")
	public ResponsePageVO<TbCustomer> list(@RequestBody CustomerVO params){
		if(ValidUtil.vaildPageRequst(params.pageRequset())) {
			return ResponsePageVO.fail(ResponseStatus.PAGE_PARAMS_ERROR);
		}
		return ResponsePageVO.success(service.listCust(params));
	}
	
	@PostMapping("/get")
	@OperationLog(name="获取客户详情")
	public ResponseDataVO<Object> get(@RequestBody CustomerVO params){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		return ResponseDataVO.success(service.getCust(params));
	}
	
	@PostMapping("/insert")
	@OperationLog(name="新增客户")
	public ResponseDataVO<Object> insert(@Valid @RequestBody CustomerVO params,BindingResult result){
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.insertCust(params));
	}
	
	@PostMapping("/update")
	@OperationLog(name="修改客户")
	public ResponseDataVO<Object> update(@Valid @RequestBody CustomerVO params,BindingResult result){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.update(params));
	}
	
	@PostMapping("/delete")
	@OperationLog(name="删除客户")
	public ResponseDataVO<Object> delete(@RequestBody CustomerVO params){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		return ResponseDataVO.success(service.delete(params));
	}
	

}
