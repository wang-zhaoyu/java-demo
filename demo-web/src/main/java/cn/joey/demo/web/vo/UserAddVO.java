package cn.joey.demo.web.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangzhaoyu
 * @date 2018/10/12 下午2:56
 */
@Data
public class UserAddVO implements Serializable{
    private static final long serialVersionUID = 3638452292844577497L;

    private String userName;

    private Integer age;
}
