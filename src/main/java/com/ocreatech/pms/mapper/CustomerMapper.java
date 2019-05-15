package com.ocreatech.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ocreatech.pms.entity.req.CustomerVO;
import com.ocreatech.pms.model.TbCustomer;

import tk.mybatis.mapper.provider.base.BaseInsertProvider;

@Mapper
public interface CustomerMapper extends BaseMapper<TbCustomer> {

	List<TbCustomer> listCust(@Param("params") CustomerVO params);

	@Select("select * from tb_customer where id = #{params.id}")
	TbCustomer getCust(@Param("params") CustomerVO params);

	@InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert(TbCustomer record);

}
