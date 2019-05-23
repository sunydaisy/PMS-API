package com.ocreatech.pms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocreatech.pms.annotation.OperationLog;
import com.ocreatech.pms.entity.basic.ResponseDataVO;
import com.ocreatech.pms.entity.req.ProjectAttrVO;
import com.ocreatech.pms.service.ProjectAttrService;
import com.ocreatech.pms.utils.ValidUtil;

@RestController
@RequestMapping("/project/attr")
public class ProjectAttrController {
	
	@Autowired
	private ProjectAttrService service;
	
	@PostMapping("/list/other")
	@OperationLog(name="查询其他项目设置")
	public ResponseDataVO<Object> listOther(@RequestBody ProjectAttrVO params){
		if(!StringUtils.hasText(params.getProjectCode())) {
			return ResponseDataVO.fail("项目编号不能为空");
		}
		return ResponseDataVO.success(service.listOther(params));
	}
	
	@PostMapping("/insert/other")
	@OperationLog(name="新增其他项目设置")
	public ResponseDataVO<Object> insertOther(@Valid @RequestBody List<ProjectAttrVO> params,BindingResult result){
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.insertOther(params));
	}
	
	
}
