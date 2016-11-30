package com.hellospring.controller;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.hellospring.dao.ICarDao;
import com.hellospring.model.Car;
import com.hellospring.model.ResultEntity;
import com.hellospring.model.User;
import com.hellospring.service.UserService;
import com.hellospring.view.UserInfoView;


@RestController
@RequestMapping("/user")
@Transactional
public class UserController {
	
	@Resource(name="userService")
	private UserService usrSrv;
	
	@Resource(name="carDao")
	private ICarDao carDao;
	
	private User user = new User();
	
	public ResultEntity newUser()
	{
		
		return null;		
	}
	
	
//	@JsonView(UserInfoView.OnlyUserInfoView.class)
	@JsonView(UserInfoView.UserIdView.class)
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResultEntity seekCar(HttpServletRequest req, @PathVariable String id)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");

		res.setData(usrSrv.getUser(Integer.parseInt(id)));
//		HttpSession ses = req.getSession();
//		res.setData(user.toString());
//		ses.setMaxInactiveInterval(10);
//		ses.invalidate();
		
		return res;
	}
	
	@JsonView(UserInfoView.AllUserInfoView.class)
	@RequestMapping(value="/with-cars-{id}", method=RequestMethod.GET)
	public ResultEntity seekCar1(@PathVariable String id)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");

		res.setData(usrSrv.getUser(Integer.parseInt(id)));
		return res;
	}
	
	@JsonView(UserInfoView.AllUserInfoView.class)
	@RequestMapping(value="/{uid}/fetch-cars-{carid}", method=RequestMethod.GET)
	public ResultEntity fetchCar(@PathVariable int uid, @PathVariable int carid)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		res.setData(usrSrv.getUserFetchCar(uid, carid));
//		res.setData(usrSrv.getUserFetchCar(Integer.parseInt(id)));
		return res;
	}
	

	@JsonView(UserInfoView.AllUserInfoView.class)
	@RequestMapping(value="/{uid}/with-color-{color}", method=RequestMethod.GET)
	public ResultEntity seekCar2(@PathVariable int uid, @PathVariable String color)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");

		User u = usrSrv.getUser(uid);
//		List<Car> carlst = carDao.getCars(color);
		List<Car> carlst = carDao.getCarsCriteria(color);
		u.setCars(new HashSet<Car>(carlst));		
		res.setData(u);
		return res;
	}
	
	
}
