package cn.mobilemart.demo.web.controller;

import cn.mobilemart.demo.api.EchoService;
import cn.mobilemart.demo.web.common.ErrorCode;
import cn.mobilemart.demo.web.common.MyPropertyPlaceholder;
import cn.mobilemart.demo.web.common.Response;
import com.baidu.disconf.client.usertools.DisconfDataGetter;
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
 * @author apple
 */
@Slf4j
@Controller
@RequestMapping("/demo")
public class EchoController {

    @Autowired
    private EchoService echoService;

    /**
     * http://localhost:8090/demo/echo?param=12345678
     * @param param
     * @return
     */
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    @ResponseBody
    public Response echo(@RequestParam(value = "param", required = false) String param) {
        Response<Map> result = new Response<>();
        Map<String, Object> data = new HashMap<String, Object>();
        Object str=DisconfDataGetter.getByFileItem("dubbo.properties", "dubbo.zookeeper");
        data.put("str",str);
        String echo = echoService.echo(param);
        data.put("param", param);
        data.put("echo", echo);
        data.put("datetime", new Date());
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        result.setData(data);
        return result;
    }

}
