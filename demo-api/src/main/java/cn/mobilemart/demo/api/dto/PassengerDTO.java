package cn.mobilemart.demo.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String token;

    private String tel;

}
