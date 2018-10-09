package cn.joey.demo.web.common;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wangzhaoyu
 * @date 2018/10/9 上午10:59
 */
public class DefaultProfileListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String env = System.getProperty("spring.profiles.active");

        //设置默认profile为test
        if (StringUtils.isBlank(env)) {
            System.setProperty("spring.profiles.active", "test");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
