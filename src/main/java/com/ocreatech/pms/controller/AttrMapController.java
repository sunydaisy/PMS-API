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
import com.ocreatech.pms.entity.req.AttrMapVO;
import com.ocreatech.pms.service.AttrMapService;
import com.ocreatech.pms.utils.ValidUtil;

@RestController
@RequestMapping("/attr/map")
public class AttrMapController {
	
	@Autowired
	private AttrMapService service;
	
	@PostMapping("/insert")
	@OperationLog(name="新增设置")
	public ResponseDataVO<Object> insert(@Valid @RequestBody AttrMapVO params,BindingResult result){
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.insertAttrMap(params));
	}
	
	@PostMapping("/autocode")
	@OperationLog(name="自动获取属性编码")
	public ResponseDataVO<Object> autocode(@RequestBody AttrMapVO params){
		if(params.getAttrType()==null) {
			return ResponseDataVO.fail("属性类型不能为空");
		}
		return ResponseDataVO.success(service.autocode(params));
	}
	
	@PostMapping("/autosort")
	@OperationLog(name="自动获取属性排序")
	public ResponseDataVO<Object> autosort(@RequestBody AttrMapVO params){
		if(params.getAttrType()==null) {
			return ResponseDataVO.fail("属性类型不能为空");
		}
		return ResponseDataVO.success(service.autosort(params));
	}

}
