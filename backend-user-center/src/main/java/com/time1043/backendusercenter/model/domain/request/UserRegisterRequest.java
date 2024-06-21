package com.time1043.backendusercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author yingzhu
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 3073882225277649662L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}