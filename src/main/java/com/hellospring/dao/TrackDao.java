package com.hellospring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hellospring.model.Track;

@Repository("trackDao")
public class TrackDao implements ITrackDao{

	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	public TrackDao(){}
	
	protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	
	@Override
	public List<Track> getTracks(int uid, int carid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTracks(int carid) {
		List list = getCurrentSession().createQuery("from track where carid=" + carid).list();
		return list;
	}

	
}
