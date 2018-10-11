package cn.joey.demo.service.impl;

import cn.joey.demo.api.EchoService;
import lombok.extern.slf4j.Slf4j;

/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:45
*/
@Slf4j
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String msg) {
        log.debug(msg);
        String env = System.getProperty("spring.profiles.active");
        System.out.println("---1---");
        return "env=" + env + ", " + msg;
    }

}