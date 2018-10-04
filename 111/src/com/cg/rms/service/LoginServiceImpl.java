package com.cg.rms.service;

import com.cg.rms.beans.User;
import com.cg.rms.dao.LoginDAO;
import com.cg.rms.dao.LoginDAOImpl;
import com.cg.rms.exception.RecruitmentException;

public class LoginServiceImpl implements LoginService {

	LoginDAO loginDao=new LoginDAOImpl();
	@Override
	public User login(String userName, String password)
			throws RecruitmentException {
		User user=loginDao.login(userName, password);
		if(user==null)
		{
			return null;
		}
		if(user.getUserName().equals(userName) && user.getPassword().equals(password))
		{
			return user;
		}
		else{
			return null;
			}
		
	}

	@Override
	public String signUp(User user) throws RecruitmentException {
		String userId=loginDao.signUp(user);
			return userId;
	}

}
