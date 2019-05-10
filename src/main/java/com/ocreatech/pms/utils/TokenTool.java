package com.ocreatech.pms.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

/**
 * token工具类
 * @author yanyaqin
 */
@Slf4j
public class TokenTool {
	
	private TokenTool() {
	    throw new IllegalStateException("Utility class");
	  }

	/**
	 * 创建token
	 * @return
	 */
	public static String creatToken() {
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";  
        try {  
           MessageDigest md = MessageDigest.getInstance("md5");  
           byte[] md5 =  md.digest(token.getBytes());  
           BASE64Encoder encoder = new BASE64Encoder();  
           return encoder.encode(md5);  
       } catch (NoSuchAlgorithmException e) { 
    	   log.info(e.getMessage(),e);
       }  
        return null;  
	}

}
