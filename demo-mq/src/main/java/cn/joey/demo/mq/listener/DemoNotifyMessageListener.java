package cn.mobilemart.demo.mq.listener;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

/**
* @Description: Demo服务
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:41
*/
public class DemoNotifyMessageListener implements MessageListener {

    @Override
    public Action consume(Message message, ConsumeContext context) {
        try {
            String msg = new String(message.getBody());
            return Action.CommitMessage;
        } catch (Exception e) {
            //消费失败
            return Action.ReconsumeLater;
        }
    }

}
