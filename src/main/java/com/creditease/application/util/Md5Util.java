package com.creditease.application.util;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * 内容摘要工具类
 * @since 1.0
 * @author liuzhibo
 */
public class Md5Util {
	
	/**
	 * 生成MD5摘要信息
	 * @param sourceString
	 * @return
	 */
	public static String MD5Encode(String src) {
		String resultString = null;
		try {
			resultString = getMD5(src);			 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
	
	/**
	 * 以字符串形式显示字节数组内容
	 * @param bytes
	 * @return
	 */
	public static final String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}
	
	/**
	 * 对文件全文生成MD5摘要
	 * @param file   要加密的文件
	 * @return MD5摘要码
	 */
	public static String getMD5(File file) throws Exception {
		FileInputStream fis = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int length = -1;			 
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			byte[] b = md.digest();
			return byte2hexString(b);
		}  finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 对一段String生成MD5加密信息
	 * @param message 要加密的String
	 * @return 生成的MD5信息
	 */
	public static String getMD5(String message) throws Exception {
		if(message==null)return null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = md.digest(message.getBytes("utf-8"));
		return byte2hexString(b); 
	}

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
