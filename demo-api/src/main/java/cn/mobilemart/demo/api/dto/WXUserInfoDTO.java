package cn.mobilemart.demo.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bostin.wang
 * @date 2017-12-27
 */
@Data
public class WXUserInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 公众号唯一标识
     */
    private String openId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户手机号
     */
    private String tel;

    /**
     * 头，末尾的0代表尺寸
     */
    private String headimgurl;

    /**
     * 性别:1男，2女，0未知
     */
    private Integer sex;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
