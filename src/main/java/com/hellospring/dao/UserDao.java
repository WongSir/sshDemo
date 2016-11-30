package com.hellospring.dao;


import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.hellospring.model.User;

@Repository("usrDao")
public class UserDao implements IUserDao {
	

	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public UserDao(){}
	
	protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	
	public User getUser(Integer id) {
		//User u = (User)getCurrentSession().load(User.class, id);
		User u = (User)getCurrentSession().createQuery("from User where id=" + id).list().get(0);
		
		return u;
	}
	
	public User getUserFetchCar(int id) {
		//User u = (User)getCurrentSession().load(User.class, id);
		User u = (User)getCurrentSession().createQuery("from User as u left join fetch u.cars where u.id=" + id).list().get(0);
//		User u = (User)getCurrentSession().createQuery("from User fetch all properties where id=" + id).uniqueResult();
		return u;
	}

	@Override
	public User getUserFetchCar(int uid, int carid) {
		Criteria cri = getCurrentSession().createCriteria(User.class);
		cri.add(Restrictions.eq("id", uid))
		.setFetchMode("cars", FetchMode.JOIN);
		
		return (User)cri.uniqueResult();
	}
	
	
	

}
