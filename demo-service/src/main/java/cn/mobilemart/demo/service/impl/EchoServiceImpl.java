package cn.mobilemart.demo.service.impl;

import cn.mobilemart.demo.api.EchoService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author apple
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