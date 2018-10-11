package cn.joey.demo.web.common;

import lombok.Data;

/**
* @Description:
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:47
*/
@Data
public class Response<T> {
    private Integer error_code;
    private String err_msg;
    private T data;
}
