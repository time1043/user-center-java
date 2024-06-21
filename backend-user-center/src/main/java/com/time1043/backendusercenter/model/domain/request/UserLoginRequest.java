package com.time1043.backendusercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author yingzhu
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = -1405097068993701042L;

    private String userAccount;
    private String userPassword;
}