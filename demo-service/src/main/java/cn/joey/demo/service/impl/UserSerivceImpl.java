package cn.joey.demo.service.impl;

import cn.joey.demo.api.UserSerivce;
import cn.joey.demo.api.entity.UserPO;
import cn.joey.demo.service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzhaoyu
 * @date 2018/10/12 下午2:35
 */
public class UserSerivceImpl implements UserSerivce {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserPO> getAllUser() {
       return userDao.selectAll();
    }

    @Override
    public void addUser(UserPO userPO) {
        userDao.insert(userPO);
    }
}
