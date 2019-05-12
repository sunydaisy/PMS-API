package com.ocreatech.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ocreatech.pms.entity.req.CustomerVO;
import com.ocreatech.pms.model.TbCustomer;

@Mapper
public interface CustomerMapper {

	List<TbCustomer> listCust(@Param("params") CustomerVO params);

}
