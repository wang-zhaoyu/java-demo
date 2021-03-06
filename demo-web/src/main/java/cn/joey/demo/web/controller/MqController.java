package cn.joey.demo.web.controller;

import cn.joey.demo.api.DemoNotifyService;
import cn.joey.demo.api.TopicSendMessage;
import cn.joey.demo.web.common.ErrorCode;
import cn.joey.demo.web.common.Response;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:47
*/
@Slf4j
@Controller
@RequestMapping("/demo")
public class MqController {


    @Autowired
    private DemoNotifyService demoNotifyService;
    @Autowired
    private TopicSendMessage topicSendMessage;


    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    @ResponseBody
    public Response notify(@RequestParam(value = "param", required = false) String param,
                           @RequestParam(value = "delay", required = false) Long delay) {
        Response<Map> result = new Response<>();
        Map<String, Object> data = new HashMap<String, Object>();

        if (delay == null) {
            delay = 0L;
        }

        JSONObject message = new JSONObject();
        message.put("param", param);
        Boolean notifyResult = demoNotifyService.notify(message, delay);
        data.put("param", param);
        data.put("result", notifyResult);
        data.put("datetime", new Date());
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/notify/activemq", method = RequestMethod.GET)
    @ResponseBody
    public Response activeMqNotify(){
        topicSendMessage.send();
        return Response.successResponse();
    }
}
