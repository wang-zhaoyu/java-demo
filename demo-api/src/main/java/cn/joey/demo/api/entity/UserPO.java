package cn.joey.demo.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzhaoyu
 * @date 2018/10/12 下午2:25
 */
@Data
public class UserPO implements Serializable{
    private static final long serialVersionUID = -4727706306150806433L;

    private Long id;

    private String userName;

    private Integer age;
}
