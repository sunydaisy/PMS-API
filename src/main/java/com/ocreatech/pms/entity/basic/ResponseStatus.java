package com.ocreatech.pms.entity.basic;

public enum ResponseStatus implements ResponseCode {
	/**
	 * 成功
	 */
	SUCCESS("200", "成功"),
	PARAM_ERROR("001", "参数错误"),
	NOT_EXIT("002", "查询记录不存在")
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
