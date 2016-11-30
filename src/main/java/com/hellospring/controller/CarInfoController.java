package com.hellospring.controller;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hellospring.dao.ICarDao;
import com.hellospring.model.Car;
import com.hellospring.model.ResultEntity;



@RestController("carController")
@RequestMapping("/car")
@EnableTransactionManagement
@Transactional
public class CarInfoController {
	
	@Resource(name="carDao")
	private ICarDao dao;
	
	//@RequestMapping(path="/coach?zone={zoneid}", method=RequestMethod.GET)
	@RequestMapping(path="/coach-{zoneid}-for-test", method=RequestMethod.GET)
	public ResultEntity listCars(@PathVariable("zoneid") String zid)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		res.setData(dao.getCars());
		
		return res;
	}
	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ResultEntity listCars1()
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		res.setData(dao.getCars());
		
		return res;
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResultEntity seekCar(@PathVariable int id)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		//Car c = cen.getCar(id);
		res.setData(dao.getCar(id));
		
		return res;
	}
	
	
	public class CarParamObject{
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResultEntity addCar(@RequestBody Car car)
	{
		return null;
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResultEntity updateCar(@PathVariable int id)
	{		
		return null;
	}
	
	@RequestMapping(path="/{id}/color", method=RequestMethod.GET)
	public ResultEntity seekColor(@PathVariable int id)
	{
		ResultEntity res = new ResultEntity();
		res.setErrorCode(0);
		res.setMessage("success");
		//Car c = cen.getCar(id);
		res.setData(dao.getCar(id).getColor());
		
		return res;		
	}
}
