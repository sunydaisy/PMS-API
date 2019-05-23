package com.ocreatech.pms.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocreatech.pms.entity.req.AttrMapVO;
import com.ocreatech.pms.mapper.AttrMapMapper;
import com.ocreatech.pms.model.TbAttrMap;

import tk.mybatis.mapper.entity.Example;

@Service
public class AttrMapService {

	@Autowired
	private AttrMapMapper mapper;
	
	/**
	 * 新增项目属性
	 * @param params
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public Long insertAttrMap(AttrMapVO params) {
		// 根据属性类型、属性排序，查询是否有相同排序的属性
		Example example = new Example(TbAttrMap.class);
		example.createCriteria().andEqualTo("attrType", params.getAttrType())
								.andEqualTo("attrSort",params.getAttrSort());
		List<TbAttrMap> list = mapper.selectByExample(example);
		// 如果存在相同排序的属性，则将该类型下的所有的排序向后推移一位
		if (!list.isEmpty()) {
			mapper.updateAttrSort(params.getAttrType(),params.getAttrSort());
		}
		// 插入新的属性
		TbAttrMap entity = new TbAttrMap();
		BeanUtils.copyProperties(params, entity);
		mapper.insert(entity);
		return entity.getId();
	}

	/**
	 * 按类型生成属性编码，如：10001
	 * @param params
	 * @return
	 */
	public Integer autocode(AttrMapVO params) {
		// 根据属性类型查询该类型下所有的属性，并按降序排列
		List<TbAttrMap> list = mapper.listAttrMapCodeDesc(params);
		// 如果该list为空，则该类型下还不存在属性，则生成后缀为0001的属性编码
		if(list.isEmpty()) {
			return Integer.getInteger(params.getAttrType()+"0001");
		}
		// 否则选取编码值最大的加一
		return list.get(0).getAttrCode()+1;
	}

	/**
	 * 按照属性类型自动获取当前属性排序
	 * @param params
	 * @return
	 */
	public Integer autosort(AttrMapVO params) {
		// 根据属性类型查询该类型下所有的属性，并按降序排列
		List<TbAttrMap> list = mapper.listAttrMapSortDesc(params);
		// 如果该list为空，则该类型下还不存在属性，则默认排序为1
		if(list.isEmpty()) {
			return 1;
		}
		return list.get(0).getAttrSort()+1;
	}

}
