package com.kamustiago.kamus.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.kamustiago.kamus.security.UserSS;

public class UserService {

	//metodo que chama funcao do springsecurity retornando usuario logado
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		} catch (Exception e) {
			return null;
		}

	}
}
