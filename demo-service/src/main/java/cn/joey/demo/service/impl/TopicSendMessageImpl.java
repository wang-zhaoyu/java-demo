package cn.joey.demo.service.impl;


import cn.joey.demo.api.TopicSendMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author wangzhaoyu
 * @date 2019/2/14 下午3:06
 */
@Component
public class TopicSendMessageImpl implements TopicSendMessage {
//    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mvc.xml");
//    private JmsTemplate jmsTemplate = (JmsTemplate) ac.getBean("jmsTemplate");
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(){
        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage();
                msg.setText("我是被发送的数据体");
                System.out.println("发送数据=============发送数据");
                return msg;
            }
        });
    }

    public void receive(){
        Message msg = jmsTemplate.receive();
        TextMessage tm = (TextMessage)msg;
        System.out.println("非监听------------------非监听");
        System.out.println(msg);
    }

    public static void main(String[] args) {
        new TopicSendMessageImpl().send();

    }
}
