package com.ocreatech.pms.learnTest.inter;

@FunctionalInterface
public interface FunctionInterface {

	int plusNum(int x,int y);
	
	default String getDefaultMessage(String msg) {
		return "我是接口中的默认方法"+msg;
	}
	
	public static String getStaticMessage(String msg) {
		return "我是接口中的静态方法"+msg;
	}
}
