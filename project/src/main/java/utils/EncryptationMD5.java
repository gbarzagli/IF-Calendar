package utils;

import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptationMD5 {
	
	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(text.getBytes(),0,text.length());
		
	    return new BigInteger(1,messageDigest.digest()).toString(16);
	}
}
