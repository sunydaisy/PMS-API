package com.ocreatech.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.ocreatech.pms.entity.req.AttrMapVO;
import com.ocreatech.pms.model.TbAttrMap;

import tk.mybatis.mapper.provider.base.BaseInsertProvider;

@Mapper
public interface AttrMapMapper extends BaseMapper<TbAttrMap> {

	@Update("UPDATE tb_attr_map set attr_sort = attr_sort+1 where attr_type = #{attrType} and attr_sort >= #{attrSort}")
	void updateAttrSort(Integer attrSort);

	@InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert(TbAttrMap record);

	List<TbAttrMap> listAttrMapCodeDesc(@Param("params") AttrMapVO params);

	List<TbAttrMap> listAttrMapSortDesc(@Param("params") AttrMapVO params);

}
