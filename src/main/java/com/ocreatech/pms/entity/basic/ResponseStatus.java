package com.ocreatech.pms.entity.basic;

public enum ResponseStatus implements ResponseCode {
	/**
	 * 成功
	 */
	SUCCESS("200", "成功"),
	PARAM_ERROR("001", "参数错误"),
	NOT_EXIT("002", "查询记录不存在"),
	ID_IS_NULL("003", "记录ID不能为空"),
	PAGE_PARAMS_ERROR("004", "分页参数不能为空"),
	UPDATE_FAIL("005","记录未更新，请检查"),
	DELETE_FAIL("006","记录未删除，请检查"),
	UNAUTHORIZED("401","没有权限访问,请先登录") 
	;
	
	private String status;
	private String msg;

	private ResponseStatus(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	@Override
	public String status() {
		return this.status;
	}

	@Override
	public String msg() {
		return this.msg;
	}
}
