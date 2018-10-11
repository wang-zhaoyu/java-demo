package cn.joey.demo.service.impl;

import cn.joey.demo.api.DemoNotifyService;
import cn.joey.demo.service.common.MyPropertyPlaceholder;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:45
*/
@Slf4j
@Component
public class DemoNotifyServiceImpl implements DemoNotifyService {

//    @Autowired
//    Producer producer;

    @Override
    public Boolean notify(JSONObject msg, long millis) {
        log.debug(msg.toJSONString());

        String topic = (String) MyPropertyPlaceholder.getProperty("mq.order_success_topic");
        Message message = new Message(topic, "*", msg.toJSONString().getBytes());
        message.setKey("order_result");

        try {
            long delayTime = System.currentTimeMillis() + millis;
            log.debug("当前时间:{}", new Date().toString());
            log.debug("延迟{}ms发送", millis);
            log.debug("预计发送时间:{}", new Date(delayTime).toString());
            message.setStartDeliverTime(delayTime);

//            SendResult sendResult = producer.send(message);
            // 同步发送消息，只要不抛异常就是成功
//            if (sendResult != null) {
//                log.debug("发送消息成功,topic={},msgId={}", message.getTopic(), sendResult.getMessageId());
//            }
            return true;
        } catch (Exception e) {
            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
            log.error("发送消息失败,topic={}", message.getTopic());
            e.printStackTrace();
        }

        return false;
    }
}