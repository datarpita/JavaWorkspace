package com.tsc.service;

import com.tsc.dao.LoginDao;
import com.tsc.entity.User;

@FunctionalInterface
public interface LoginFuncIntService {
	
	public boolean isValid(User user, LoginDao loginDao);

}
