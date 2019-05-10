package com.ocreatech.pms.entity.basic;

import lombok.Data;

@Data
public class ResponseDataVO<T> {
	
	private Boolean success;
	
	private String status;
	
	private String msg;
	
	private T data;
	
	public ResponseDataVO() {
		this.success = false;
		this.status = null;
		this.msg = null;
		this.data = null;
	}
	
	public ResponseDataVO(ResponseCode code) {
		this.success = code.status().equals(ResponseStatus.SUCCESS.status());
		this.status = code.status();
		this.msg = code.msg();
		this.data = null;
	}
	
	public static <T> ResponseDataVO<T> success() {
		return new ResponseDataVO<>(ResponseStatus.SUCCESS);
	}
	
	public static <T> ResponseDataVO<T> success(T data) {
		ResponseDataVO<T> responseDataVO = new ResponseDataVO<>(ResponseStatus.SUCCESS);
		responseDataVO.setData(data);
		return responseDataVO;
	}
	
	public static <T> ResponseDataVO<T> success(ResponseCode code) {
		return new ResponseDataVO<>(code);
	}
	
	public static <T> ResponseDataVO<T> fail(ResponseCode code) {
		return new ResponseDataVO<>(code);
	}
	
	public static <T> ResponseDataVO<T> fail(String msg) {
		ResponseDataVO<T> responseDataVO = new ResponseDataVO<>();
		responseDataVO.setMsg(msg);
		return responseDataVO;
	}

}
