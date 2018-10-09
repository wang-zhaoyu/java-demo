package cn.mobilemart.demo.service.impl;

import cn.mobilemart.demo.api.PassengerService;
import cn.mobilemart.demo.api.entity.PassengerPO;
import cn.mobilemart.demo.service.dao.PassengerDao;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author apple
 */
@Service("passengerService")
@Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW)
public class PassengerServiceImpl implements PassengerService {
    Logger log= LoggerFactory.getLogger(PassengerServiceImpl.class);
    @Autowired
    private PassengerDao passengerDao;

    @Override
    public boolean accountCreate(int type, JSONObject jsonObject, String ipStr) {
        PassengerPO pPo = new PassengerPO();

        pPo.setName("demo");
        pPo.setUserMoney(0);
        pPo.setOpenId("demo-openId");
        pPo.setRegIp(ipStr);
        pPo.setType((byte) type);
        pPo.setLastLoginIp(ipStr);
        pPo.setLastLoginTime(new Date());
        pPo.setAddTime(new Date());
        passengerDao.accountInsert(pPo);
        return true;
    }

    @Override
    public int accountInsert(PassengerPO passengerPO) {
        log.debug("pPo>>>>>>"+passengerPO.toString());
        return passengerDao.accountInsert(passengerPO);
    }
}
