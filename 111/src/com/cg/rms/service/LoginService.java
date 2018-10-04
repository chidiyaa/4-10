package com.cg.rms.service;

import com.cg.rms.beans.User;
import com.cg.rms.exception.RecruitmentException;

public interface LoginService {
	public User login(String userName,String password) throws RecruitmentException;
	public String signUp(User user) throws RecruitmentException;

}
