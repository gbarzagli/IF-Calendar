package utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Utils {
	
	public static String encrypt(String text) {
		return DigestUtils.md5Hex(text);
	}
}
