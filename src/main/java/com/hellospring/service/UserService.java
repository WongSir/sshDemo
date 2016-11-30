package com.hellospring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hellospring.dao.IUserDao;
import com.hellospring.model.User;

@Component("userService")
public class UserService {
	@Resource(name="usrDao")
	private IUserDao dao;
	
	public User getUser(int uid)
	{
		return dao.getUser(uid);
	}
	
	public User getUserFetchCar(int uid){
		return dao.getUserFetchCar(uid);
	}
	
	public User getUserFetchCar(int uid, int carid){
		return dao.getUserFetchCar(uid, carid);
	}
	
}
