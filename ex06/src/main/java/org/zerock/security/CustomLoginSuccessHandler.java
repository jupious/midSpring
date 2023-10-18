package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		log.warn("Login Success");

		List<String> roleNames = new ArrayList<>();
			//해당 권한정보 객체 가져오기
		auth.getAuthorities().forEach(authority -> {
			//						해당 권한정보 가져오기
			roleNames.add(authority.getAuthority());
		});

		log.warn("ROLE NAMES: " + roleNames);
		//			  리스트가 해당 정보를 포함하고있는지 확인하는 메소드
		if (roleNames.contains("ROLE_ADMIN")) {

			response.sendRedirect("/sample/admin");
			return;
		}

		if (roleNames.contains("ROLE_MEMBER")) {

			response.sendRedirect("/sample/member");
			return;
		}

		response.sendRedirect("/");

	}

}
