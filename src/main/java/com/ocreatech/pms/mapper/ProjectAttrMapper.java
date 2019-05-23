package com.ocreatech.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ocreatech.pms.entity.req.ProjectAttrVO;
import com.ocreatech.pms.entity.resp.ProjectAttrRespVO;
import com.ocreatech.pms.model.TbProjectAttr;

@Mapper
public interface ProjectAttrMapper extends BaseMapper<TbProjectAttr> {

	@Select("select "
			+ "t.*,"
			+ "m.attr_sort,"
			+ "m.attr_type "
			+ "from tb_project_attr t,tb_attr_map m "
			+ "where project_code = #{projectCode} "
			+ "and t.project_attr_code = m.attr_code "
			+ "order by m.attr_type asc, m.attr_sort asc")
	List<TbProjectAttr> listAttrByProjectCode(String projectCode);

	List<ProjectAttrRespVO> listOther(@Param("params") ProjectAttrVO params);

	int updateProjectAttrBatch(@Param("list") List<TbProjectAttr> projectAttr);


}
