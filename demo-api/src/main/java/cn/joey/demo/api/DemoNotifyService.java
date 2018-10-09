package cn.mobilemart.demo.api;

import com.alibaba.fastjson.JSONObject;

/**
* @Description: Demo服务
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:41
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
