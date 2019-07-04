package com.pumakuki.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

public class BCryptEncoderTest {

	public static void main(String[] args) {
	
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		String encodedString;
		for(int i=1;i<=10;i++) {
			encodedString = encoder.encode("password@123!");
			System.out.println(encodedString);
		}
		

	}

}
