package com.cap.cloud_note.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class NoteUtil {
	/**
	 * 采用MD5摘要算法处理信息
	 */
	public static String md5(String msg){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			
			byte[] input = msg.getBytes();
			byte[] output = md.digest(input);
			
			//采用base64算法将字节数组转换为字符串
			String base64_msg = Base64.encode(output);
			return base64_msg;
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 生成UUID
	 * @return
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
