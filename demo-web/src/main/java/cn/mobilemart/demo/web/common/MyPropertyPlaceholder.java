package cn.mobilemart.demo.web.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author bostin
 */
public class MyPropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private static Map<String, String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        propertyMap = new HashMap<>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

    public static Object getProperty(String name) {
        return propertyMap.get(name);
    }
}