package com.ocreatech.pms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocreatech.pms.entity.req.ProjectAttrVO;
import com.ocreatech.pms.entity.resp.ProjectAttrGroupRespVO;
import com.ocreatech.pms.entity.resp.ProjectAttrRespVO;
import com.ocreatech.pms.mapper.ProjectAttrMapper;
import com.ocreatech.pms.model.TbProjectAttr;

@Service
public class ProjectAttrService {
	
	@Autowired
	private ProjectAttrMapper mapper;

	/**
	 * 优化---结构优化、进行排序
	 * 查询项目设置，展示该项目没有的项目设置
	 * @param params
	 * @return
	 */
	public List<ProjectAttrGroupRespVO> listOther(ProjectAttrVO params) {
		// 查询其他项目设置
		List<ProjectAttrRespVO> projectAttrList = mapper.listOther(params);
		// 按属性类型进行分组排序
		Map<Integer, List<ProjectAttrRespVO>> projectAttrMap = projectAttrList.stream()
				.collect(Collectors.groupingBy(ProjectAttrRespVO::getAttrType));
		// 封装返回格式
		List<ProjectAttrGroupRespVO> groupList = new ArrayList<>();
		for (Map.Entry<Integer, List<ProjectAttrRespVO>> entryMap : projectAttrMap.entrySet()) {
			ProjectAttrGroupRespVO group = new ProjectAttrGroupRespVO();
			ProjectAttrRespVO projectAttr = entryMap.getValue().get(0);
			group.setAttrType(projectAttr.getAttrType());
			group.setAttrTypeName(projectAttr.getAttrTypeName());
			group.setAttrList(entryMap.getValue());
			groupList.add(group);
		}
		return groupList;
	}

	/**
	 * 批量新增项目设置属性，此时项目设置属性值为空
	 * @param params
	 * @return
	 */
	public int insertOther(List<ProjectAttrVO> params) {
		List<TbProjectAttr> entitys = new ArrayList<>();
		for(ProjectAttrVO projectAttrVO : params) {
			TbProjectAttr entity = new TbProjectAttr();
			BeanUtils.copyProperties(projectAttrVO, entity);
			entitys.add(entity);
		}
		return mapper.insertList(entitys);
	}

}
