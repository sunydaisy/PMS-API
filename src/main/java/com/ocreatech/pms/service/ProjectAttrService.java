package com.ocreatech.pms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ocreatech.pms.entity.req.ProjectAttrVO;
import com.ocreatech.pms.entity.resp.ProjectAttrRespVO;
import com.ocreatech.pms.mapper.ProjectAttrMappper;
import com.ocreatech.pms.model.TbProjectAttr;

@Service
public class ProjectAttrService {
	
	@Autowired
	private ProjectAttrMappper mapper;

	/**
	 * 查询项目设置，展示该项目没有的项目设置
	 * @param params
	 * @return
	 */
	public Map<String, List<ProjectAttrRespVO>> listOther(ProjectAttrVO params) {
		List<ProjectAttrRespVO> projectAttr = mapper.listOther(params.getProjectCode());
		return projectAttr.stream().collect(Collectors.groupingBy(ProjectAttrRespVO::getAttrTypeName));
	}

	/**
	 * 批量新增项目设置属性，此时项目设置属性值为空
	 * @param params
	 * @return
	 */
	public int insertOther(@Valid List<ProjectAttrVO> params) {
		List<TbProjectAttr> entitys = new ArrayList<>();
		for(ProjectAttrVO projectAttrVO : params) {
			TbProjectAttr entity = new TbProjectAttr();
			BeanUtils.copyProperties(projectAttrVO, entity);
			entitys.add(entity);
		}
		return mapper.insertList(entitys);
	}

}
