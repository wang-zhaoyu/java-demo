package cn.mobilemart.demo.service.dao.impl;

import cn.mobilemart.demo.api.entity.PassengerPO;
import cn.mobilemart.demo.service.common.BaseDaoSupport;
import cn.mobilemart.demo.service.dao.PassengerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("passengerDao")
public class PassengerDaoImpl extends BaseDaoSupport implements PassengerDao{
    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    Logger log= LoggerFactory.getLogger(PassengerDaoImpl.class);
    String accountInsertSql="insert into mgo_passenger(name,reg_ip,user_money,last_login_ip,last_login_time,add_time) VALUES (?,?,?,?,?,?)";

    @Override
    public int accountInsert(PassengerPO passengerPO) {
        log.debug("passengerPO.name>>>"+passengerPO.getName());
        Object[] args={passengerPO.getName(),passengerPO.getRegIp(),passengerPO.getUserMoney(),passengerPO.getLastLoginIp(),passengerPO.getLastLoginTime(),passengerPO.getAddTime()};
        return this.insert(jdbcTemplate,accountInsertSql,args);
    }
}
