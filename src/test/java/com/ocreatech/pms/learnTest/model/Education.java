package com.ocreatech.pms.learnTest.model;

import lombok.Data;

@Data
public class Education implements Cloneable{
	private String school;
	private String diploma;
	
	@Override
	public Education clone() {
		Education edu = null;
		try {
			edu = (Education) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return edu;
	}
}
