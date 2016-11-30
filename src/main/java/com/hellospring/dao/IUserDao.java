package com.hellospring.dao;

import com.hellospring.model.User;

public interface IUserDao {
    User getUser(Integer id);
    User getUserFetchCar(int uid);
    User getUserFetchCar(int uid, int carid);
}
