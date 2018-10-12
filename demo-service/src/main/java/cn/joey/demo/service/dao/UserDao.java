package cn.joey.demo.service.dao;

import cn.joey.demo.api.entity.UserPO;

import java.util.List;

/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:45
*/
public interface UserDao {

    int insert(UserPO userPO);

    List<UserPO> selectAll();
}
