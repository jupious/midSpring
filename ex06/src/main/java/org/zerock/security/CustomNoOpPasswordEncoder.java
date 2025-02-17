package org.zerock.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {
		//패스워드 암호화
		log.warn("before encode :" + rawPassword);

		return rawPassword.toString();
	}
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//패스워드 체크
		log.warn("matches: " + rawPassword + ":" + encodedPassword);

		return rawPassword.toString().equals(encodedPassword);
	}
}
