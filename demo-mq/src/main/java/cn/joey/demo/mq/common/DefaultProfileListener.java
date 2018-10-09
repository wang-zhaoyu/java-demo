package cn.mobilemart.demo.mq.common;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:41
*/
public class DefaultProfileListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String env = System.getProperty("spring.profiles.active");

        //设置默认profile为test
        if (StringUtils.isBlank(env)) {
            System.setProperty("spring.profiles.active", "test");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}