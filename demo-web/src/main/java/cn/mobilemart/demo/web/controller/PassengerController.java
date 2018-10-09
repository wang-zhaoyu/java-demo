package cn.mobilemart.demo.web.controller;

import cn.mobilemart.demo.api.PassengerService;
import cn.mobilemart.demo.api.entity.PassengerPO;
import cn.mobilemart.demo.web.common.NetWorkUtil;
import cn.mobilemart.demo.web.dto.ReturnDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author:lvkang
 * dec:乘客接口类
 */
@Slf4j
@Controller
@RequestMapping("/demo")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /**
     * 
     * @param name
     * @param userMoney
     * @param openID
     * @param type
     * @param request
     * @return
     */
    @RequestMapping(value = "/accountInsert", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    public ReturnDto accountInsert(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "userMoney", required = false) Integer userMoney,
                                   @RequestParam(value = "openID", required = false) String openID,
                                   @RequestParam(value = "type", required = false) Integer type,
                                   HttpServletRequest request) {
        PassengerPO pPo = new PassengerPO();
        String ipStr= NetWorkUtil.getRemoteAddr(request);
        pPo.setName(name);
        pPo.setUserMoney(userMoney);
        pPo.setOpenId(openID);
        pPo.setRegIp(ipStr);
        pPo.setType(type.byteValue());
        pPo.setLastLoginIp(ipStr);
        pPo.setLastLoginTime(new Date());
        pPo.setAddTime(new Date());
        try {
            int accountInsertStatus = this.passengerService.accountInsert(pPo);
            if(accountInsertStatus>0){
                return new ReturnDto("1","乘客添加成功");
            }else{
                return new ReturnDto("-1","乘客添加失败");
            }
        }catch (Exception e){
            return new ReturnDto("-6"," 接口异常");
        }
    }

}