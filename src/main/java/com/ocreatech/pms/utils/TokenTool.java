package com.ocreatech.pms.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Base64.Encoder;

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
           Encoder encoder = Base64.getEncoder();  
           return encoder.encodeToString(md5);
       } catch (NoSuchAlgorithmException e) { 
    	   log.info(e.getMessage(),e);
       }  
        return null;  
	}

}
