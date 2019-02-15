package cn.joey.demo.mq.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author wangzhaoyu
 * @date 2019/2/14 下午3:03
 */
public class TopicMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("监听==================监听");
        try {
            System.out.println("监听到的message："+message);
            TextMessage tm = (TextMessage)(message);
            System.out.println("监听到的text:"+tm.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
