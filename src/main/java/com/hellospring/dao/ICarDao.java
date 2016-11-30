package com.hellospring.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hellospring.model.Car;


public interface ICarDao {
	void saveCar(Car car);
	Car getCar(Integer id);
	List<Car> getCars();
	List<Car> getCars(int uid);
	List<Car> getCars(String color);
	void updateCar(Car car);
	void deleteCar(Car car);
	List<Car> getCarsCriteria(String color);
}
