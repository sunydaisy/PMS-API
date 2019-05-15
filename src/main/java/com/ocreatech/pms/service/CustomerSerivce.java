package com.ocreatech.pms.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ocreatech.pms.entity.basic.ResponseStatus;
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
	public Page<TbCustomer> listCust(CustomerVO params) {
		return PageHelper.startPage(params.pageRequset()).doSelectPage(() -> customerMapper.listCust(params));
	}

	/**
	 * 获取客户详情
	 * @param params
	 * @return
	 */
	public TbCustomer getCust(CustomerVO params) {
		return customerMapper.getCust(params);
	}

	/**
	 * 新增客户信息
	 * @param params
	 * @return
	 */
	public Long insertCust(CustomerVO params) {
		TbCustomer entity = new TbCustomer();
		BeanUtils.copyProperties(params, entity);
		entity.setDelFlag(false);
		entity.setCreatTime(LocalDateTime.now());
		customerMapper.insert(entity);
		return entity.getId();
	}

	/**
	 * 修改客户信息
	 * @param params
	 * @return
	 */
	public ResponseStatus update(CustomerVO params) {
		TbCustomer entity = new TbCustomer();
		BeanUtils.copyProperties(params, entity);
		int result = customerMapper.updateByPrimaryKeySelective(entity);
		if (result < 1) {
			return ResponseStatus.UPDATE_FAIL;
		}
		return ResponseStatus.SUCCESS;
	}

	/**
	 * 删除客户信息
	 * @param params
	 * @return
	 */
	public Object delete(CustomerVO params) {
		int result = customerMapper.deleteByPrimaryKey(params.getId());
		if (result < 1) {
			return ResponseStatus.DELETE_FAIL;
		}
		return ResponseStatus.SUCCESS;
	}

}
