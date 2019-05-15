package com.ocreatech.pms.utils;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ocreatech.pms.entity.basic.PageRequestVO;

/**
 * 分页
 * @author yanyaqin
 *
 */
public class MyPageHelper extends PageHelper{
	
	public static <T> Page<T> doSelectPage(PageRequestVO page,ISelect select){
		return startPage(page.getPageNum(), page.getPageSize(), true).doSelectPage(select);
	}

}
