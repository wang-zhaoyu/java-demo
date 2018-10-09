package cn.mobilemart.demo.web.common;

import lombok.Data;

/**
 * @author bostin.wang
 * @date 2017-12-22
 */
@Data
public class Response<T> {
    private Integer error_code;
    private String err_msg;
    private T data;
}
