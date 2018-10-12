package cn.joey.demo.api;

import cn.joey.demo.api.entity.UserPO;

import java.util.List;

/**
 * @author wangzhaoyu
 * @date 2018/10/12 下午2:34
 */
public interface UserSerivce {

    List<UserPO> getAllUser();

    void addUser(UserPO userPO);
}
