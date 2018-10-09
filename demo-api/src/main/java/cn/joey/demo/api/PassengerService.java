package cn.mobilemart.demo.api;

import cn.mobilemart.demo.api.entity.PassengerPO;
import com.alibaba.fastjson.JSONObject;


/**
* @Description: 乘客service业务类
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:41
*/
public interface PassengerService {

    boolean accountCreate(int type, JSONObject jsonObject, String ipStr);

    int accountInsert(PassengerPO passengerPO);

}
