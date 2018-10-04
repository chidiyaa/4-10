package com.cg.rms.dao;

import com.cg.rms.beans.User;
import com.cg.rms.exception.RecruitmentException;

public interface LoginDAO {

	public String signUp(User user) throws RecruitmentException;
	public User login(String userName,String password) throws RecruitmentException;
}
