package com.hellospring.dao;

import java.util.List;

import com.hellospring.model.Track;

public interface ITrackDao {
	List<Track> getTracks(int uid, int carid);
	List<Track> getTracks(int carid);	
}
