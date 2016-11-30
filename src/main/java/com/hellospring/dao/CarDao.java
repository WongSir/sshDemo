package com.hellospring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hellospring.model.Car;

@Repository("carDao")
public class CarDao implements ICarDao {
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public CarDao(){}
	
	protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public void saveCar(Car car) {
		// TODO Auto-generated method stub
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Car> getCars(){
		List list = getCurrentSession().createQuery(
                "from Car"
           ).list();
		return list;
	}
   
	@SuppressWarnings("unchecked")
	public Car getCar(Integer id) {
		
		List list = getCurrentSession().createQuery(
                "from Car where id="+id
           ).list();
		return (Car)list.get(0);
	}


	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		
	}


	public void deleteCar(Car car) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Car> getCars(int uid) {
		List list = getCurrentSession().createQuery(
                "from Car where usr.id=" + uid
           ).list();
		return list;
	}

	public List<Car> getCars(String color){
		return getCurrentSession().createQuery("from Car where color='" + color + "'").list();
	}
	
	public List<Car> getCarsCriteria(String color){
		Criteria cri = getCurrentSession().createCriteria(Car.class);
		cri.add(Restrictions.eq("color", color));
		
		return cri.list();
	}
}
