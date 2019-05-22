package com.ocreatech.pms.controller;

import java.security.NoSuchAlgorithmException;

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
import com.ocreatech.pms.entity.req.ProjectVO;
import com.ocreatech.pms.entity.resp.ProjectRespVO;
import com.ocreatech.pms.service.ProjectService;
import com.ocreatech.pms.utils.ValidUtil;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@PostMapping("/list")
	@OperationLog(name="项目列表查询")
	public ResponsePageVO<ProjectRespVO> list(@RequestBody ProjectVO params){
		if(ValidUtil.vaildPageRequst(params.pageRequset())) {
			return ResponsePageVO.fail(ResponseStatus.PAGE_PARAMS_ERROR);
		}
		return ResponsePageVO.success(service.listProject(params));
	}
	
	@PostMapping("/insert")
	@OperationLog(name="新增项目")
	public ResponseDataVO<Object> insert(@Valid @RequestBody ProjectVO params,BindingResult result){
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.insertProject(params));
	}
	
	@PostMapping("/update")
	@OperationLog(name="修改项目")
	public ResponseDataVO<Object> update(@Valid @RequestBody ProjectVO params,BindingResult result){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		if(result.hasErrors()) {
			return ResponseDataVO.fail(ValidUtil.getErrorMsg(result));
		}
		return ResponseDataVO.success(service.updateProject(params));
	}

	@PostMapping("/get")
	@OperationLog(name="获取项目详情")
	public ResponseDataVO<Object> get(@RequestBody ProjectVO params){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		return ResponseDataVO.success(service.getProjectDetail(params));
	}
	
	@PostMapping("/delete")
	@OperationLog(name="删除")
	public ResponseDataVO<Object> delete(@RequestBody ProjectVO params){
		if(params.getId() == null) {
			return ResponseDataVO.fail(ResponseStatus.ID_IS_NULL);
		}
		return ResponseDataVO.success(service.deleteProject(params));
	}
	
	@PostMapping("/autoCode")
	@OperationLog(name="获取项目编码")
	public ResponseDataVO<Object> autoCode() throws NoSuchAlgorithmException{
		return ResponseDataVO.success(service.autoCode());
	}
}
