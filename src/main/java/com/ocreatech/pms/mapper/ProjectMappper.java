package com.ocreatech.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ocreatech.pms.entity.req.ProjectVO;
import com.ocreatech.pms.entity.resp.ProjectRespVO;
import com.ocreatech.pms.model.TbProjectInfo;

import tk.mybatis.mapper.provider.base.BaseInsertProvider;

@Mapper
public interface ProjectMappper extends BaseMapper<TbProjectInfo> {

	List<ProjectRespVO> listProjectInfo(@Param("params") ProjectVO params);

	@InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
	int insert(TbProjectInfo record);

	@Select("select * from tb_project_info where id = #{id}")
	TbProjectInfo getProjectInfo(@Param("id") Long id);

	@Update("update tb_project_info set del_flag = 1 where id = #{id}")
	int deleteById(Long id);

}
