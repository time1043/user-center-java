package com.time1043.backendusercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time1043.backendusercenter.mapper.UserMapper;
import com.time1043.backendusercenter.model.domain.User;
import com.time1043.backendusercenter.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author yingzhu
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-05-19 18:43:42
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




