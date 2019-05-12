package com.ocreatech.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocreatech.pms.entity.req.CustomerVO;
import com.ocreatech.pms.mapper.CustomerMapper;
import com.ocreatech.pms.model.TbCustomer;

/**
 * 客户信息
 * @author Daisy
 *
 */
@Service
public class CustomerSerivce {
	
	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 查询客户信息列表
	 * @param params
	 * @return
	 */
	public List<TbCustomer> listCust(CustomerVO params) {
		return customerMapper.listCust(params);
	}

}
