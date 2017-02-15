package com.qlexample.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordUtil {
     
	public static void main(String[] args) {
		SimpleHash hash = new SimpleHash("md5","123","8d78869f470951332959580424d4bf4f",2);
		System.out.println(hash.toHex());
	}
}
