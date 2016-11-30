package com.hellospring.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hellospring.dao.ICarDao;
import com.hellospring.model.ResultEntity;

@RestController
public class CarColorController {

	@Resource(name="carDao")
	private ICarDao dao;
	
	@RequestMapping(path="/{id}/color", method=RequestMethod.GET)
	public ResultEntity seekCar(@PathVariable int id)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		//Car c = cen.getCar(id);
		res.setData(dao.getCar(id).getColor());
		
		return res;
	}
	
}
