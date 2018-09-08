package com.alta.japprtc2.dao.impl;

import com.alta.japprtc2.dao.BaseDao;
import com.alta.japprtc2.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by baiba on 2018-09-08.
 */
@Component
public class UserDao extends BaseDao<User> {
    private static final String SELECT_ALL = "select `name`,`password` from user where id=?";
    public List<User> all() {
        return super.all(SELECT_ALL, 2);
    }
}
