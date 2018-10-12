package cn.joey.demo.web.controller;

import cn.joey.demo.api.EchoService;
import cn.joey.demo.api.UserSerivce;
import cn.joey.demo.api.entity.UserPO;
import cn.joey.demo.web.common.ErrorCode;
import cn.joey.demo.web.common.MyPropertyPlaceholder;
import cn.joey.demo.web.common.Response;
import cn.joey.demo.web.vo.UserAddVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:47
*/
@Slf4j
@Controller
@RequestMapping("/demo")
public class EchoController {

    @Autowired
    private EchoService echoService;
    @Autowired
    private UserSerivce userSerivce;

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
        String echo = echoService.echo("hahaha,im comming");
        log.info("接口调用结果为-->{}",echo);
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    @ResponseBody
    public Response echo() {
        Response<List<UserPO>> result = new Response<>();
        List<UserPO> allUser = userSerivce.getAllUser();
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        result.setData(allUser);
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(@RequestBody UserAddVO userAddVO) {
        Response<List<UserPO>> result = new Response<>();
        UserPO userPO = new UserPO();
        userPO.setUserName(userAddVO.getUserName());
        userPO.setAge(userAddVO.getAge());
        userSerivce.addUser(userPO);
        result.setError_code(ErrorCode.SUCCESS.code);
        result.setErr_msg(ErrorCode.SUCCESS.message);
        return result;
    }

}
