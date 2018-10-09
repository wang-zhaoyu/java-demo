package cn.mobilemart.demo.api;

import com.alibaba.fastjson.JSONObject;

/**
 * Demo服务
 *
 * @author bostin.wang
 * @date 2018-03-03
 */
public interface DemoNotifyService {
    /**
     * 向MQ发送消息
     *
     * @param msg    消息body，json字符串
     * @param millis 延迟发送时间，单位毫秒
     * @return
     */
    Boolean notify(JSONObject msg, long millis);
}
