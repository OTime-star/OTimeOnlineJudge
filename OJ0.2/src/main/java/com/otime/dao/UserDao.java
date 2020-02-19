package com.otime.dao;

import java.util.List;

import com.otime.bean.User;

public interface UserDao {
    int insert(User user);

    User selectByPrimaryKey(Integer id);
    
    User selectByEmail(String email);
    
    User selectByNickname(String nickname);
    
    List<User> selectAll();

    int updateByPrimaryKey(User user);
    
    int deleteByPrimaryKey(Integer id);

}
