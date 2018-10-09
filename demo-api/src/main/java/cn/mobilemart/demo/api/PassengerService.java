package cn.mobilemart.demo.api;

import cn.mobilemart.demo.api.entity.PassengerPO;
import com.alibaba.fastjson.JSONObject;


/**
 * @author apple
 * @dec 乘客service业务类
 */
public interface PassengerService {

    boolean accountCreate(int type, JSONObject jsonObject, String ipStr);

    int accountInsert(PassengerPO passengerPO);

}
