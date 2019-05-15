package com.ocreatech.pms.entity.basic;

import java.util.Collection;

import com.github.pagehelper.Page;
import lombok.Data;

@Data
public class ResponsePageVO<T> {
	
	private Boolean success;
	
	private String status;
	
	private String msg;
	
	private Collection<T> data;
	
	private Long total;
	
	private Integer pageSize;
	
	private Integer pageNum;
	
	
	public ResponsePageVO() {
		this.success = false;
		this.status = null;
		this.msg = null;
		this.data = null;
		this.total = null;
		this.pageSize = null;
		this.pageNum = null;
	}
	
	public ResponsePageVO(ResponseCode code) {
		this.success = code.status().equals(ResponseStatus.SUCCESS.status());
		this.status = code.status();
		this.msg = code.msg();
		this.data = null;
		this.total = null;
		this.pageSize = null;
		this.pageNum = null;
	}
	
	public static <T> ResponsePageVO<T> success() {
		return new ResponsePageVO<>(ResponseStatus.SUCCESS);
	}
	
	public static <T> ResponsePageVO<T> success(Page<T> data) {
		ResponsePageVO<T> responseDataVO = new ResponsePageVO<>(ResponseStatus.SUCCESS);
		responseDataVO.setData(data.getResult());
		responseDataVO.setTotal(data.getTotal());
		responseDataVO.setPageSize(data.getPageSize());
		responseDataVO.setPageNum(data.getPageNum());
		return responseDataVO;
	}
	
	public static <T> ResponsePageVO<T> success(Collection<T> result,Long total,Integer pageSize,Integer pageNum) {
		ResponsePageVO<T> responseDataVO = new ResponsePageVO<>(ResponseStatus.SUCCESS);
		responseDataVO.setData(result);
		responseDataVO.setTotal(total);
		responseDataVO.setPageSize(pageSize);
		responseDataVO.setPageNum(pageNum);
		return responseDataVO;
	}
	
	public static <T> ResponsePageVO<T> success(ResponseCode code) {
		return new ResponsePageVO<>(code);
	}
	
	public static <T> ResponsePageVO<T> fail(ResponseCode code) {
		return new ResponsePageVO<>(code);
	}
	
	public static <T> ResponsePageVO<T> fail(String msg) {
		ResponsePageVO<T> responseDataVO = new ResponsePageVO<>();
		responseDataVO.setMsg(msg);
		return responseDataVO;
	}

}
