package com.ocreatech.pms.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.ocreatech.pms.entity.basic.PageRequestVO;

public class ValidUtil {
	
	private ValidUtil() {
	    throw new IllegalStateException("Utility class");
	  }

	/**
	 * 获取参数校验的错误信息
	 * @param result
	 * @return
	 */
	public static String getErrorMsg(BindingResult result) {
		FieldError fieldError = result.getFieldError();
		if (fieldError == null) {
			List<ObjectError> errorlist = result.getAllErrors();
			return errorlist.stream().filter(Objects::nonNull).map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
		}
		return fieldError.getDefaultMessage();
	}

	/**
	 * 分页参数不能为空
	 * @param pageRequset
	 * @return
	 */
	public static boolean vaildPageRequst(PageRequestVO pageRequset) {
		return pageRequset.getPageNum()==null||pageRequset.getPageSize()==null;
	}

}
