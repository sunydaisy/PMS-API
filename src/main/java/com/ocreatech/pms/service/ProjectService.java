package com.ocreatech.pms.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.ocreatech.pms.entity.basic.ResponseStatus;
import com.ocreatech.pms.entity.req.ProjectVO;
import com.ocreatech.pms.entity.resp.ProjectDetailRespVO;
import com.ocreatech.pms.entity.resp.ProjectRespVO;
import com.ocreatech.pms.mapper.ProjectAttrMappper;
import com.ocreatech.pms.mapper.ProjectMappper;
import com.ocreatech.pms.model.TbProjectAttr;
import com.ocreatech.pms.model.TbProjectInfo;
import com.ocreatech.pms.utils.MyPageHelper;

/**
 * 项目信息
 * @author yanyaqin
 */
@Service
public class ProjectService {
	
	@Autowired
	private ProjectMappper mapper;
	
	@Autowired
	private ProjectAttrMappper projectAttrMapper;

	/**
	 * 查询项目列表
	 * @param params
	 * @return
	 */
	public Page<ProjectRespVO> listProject(ProjectVO params) {
		return MyPageHelper.doSelectPage(params.pageRequset(),() -> mapper.listProjectInfo(params));
	}

	/**
	 * 新增项目
	 * @param params
	 * @return
	 */
	public Long insertProject(ProjectVO params) {
		TbProjectInfo entity = new TbProjectInfo();
		BeanUtils.copyProperties(params, entity);
		entity.setDelFlag(false);
		entity.setCreatTime(LocalDateTime.now());
		mapper.insert(entity);
		return entity.getId();
	}

	/**
	 * 修改项目
	 * @param params
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	public ResponseStatus updateProject(ProjectVO params) {
		// 修改项目
		TbProjectInfo entity = new TbProjectInfo();
		BeanUtils.copyProperties(params, entity);
		int result = mapper.updateByPrimaryKeySelective(entity);
		if(result < 1) {
			return ResponseStatus.UPDATE_FAIL;
		}
		// 修改项目属性
		List<TbProjectAttr> projectAttr = params.getProjectAttrs();
		projectAttrMapper.updateProjectAttrBatch(projectAttr);
		return ResponseStatus.SUCCESS;
	}

	/**
	 * 获取项目详情
	 * @param params
	 * @return
	 */
	public ProjectDetailRespVO getProjectDetail(ProjectVO params) {
		// 查询项目信息
		TbProjectInfo projectInfo = mapper.getProjectInfo(params.getId());
		// 查询项目属性信息
		List<TbProjectAttr> projectAttrs = projectAttrMapper.listAttrByProjectCode(projectInfo.getProjectCode());
		// 数据封装返回
		ProjectDetailRespVO projectDetailRespVO = new ProjectDetailRespVO();
		BeanUtils.copyProperties(projectInfo, projectDetailRespVO);
		projectDetailRespVO.setProjectAttrs(projectAttrs);
		return projectDetailRespVO;
	}

	/**
	 * 删除项目
	 * @param params
	 * @return
	 */
	public ResponseStatus deleteProject(ProjectVO params) {
		int result = mapper.deleteById(params.getId());
		if(result < 1) {
			return ResponseStatus.DELETE_FAIL;
		}
		return ResponseStatus.SUCCESS;
	}

}
