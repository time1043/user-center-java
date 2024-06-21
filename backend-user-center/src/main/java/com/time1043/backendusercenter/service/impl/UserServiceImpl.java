package com.time1043.backendusercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time1043.backendusercenter.mapper.UserMapper;
import com.time1043.backendusercenter.model.domain.User;
import com.time1043.backendusercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.time1043.backendusercenter.contant.UserConstant.USER_LOGIN_STATE;

/**
 * @author yingzhu
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-05-19 18:43:42
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 密码加密盐
     */
    private static final String SALT = "eleven";

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return
     */
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1;  // todo 后续封装为自定义异常
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        // 账户不能包含特殊字符 正则表达式
        String validPattern = "^[a-zA-Z0-9]+$";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (!matcher.find()) {
            return -1;
        }
        // 密码和检验密码一致
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        // 账户不能重复 先数据库查询 查询数据库有性能的消耗要放在后面
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }

        // 对密码进行加密处理
        String encryptPassword = DigestUtils.md5DigestAsHex((userPassword + SALT).getBytes());

        // 插入数据到数据库
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean saveResult = this.save(user);
        if (!saveResult) {
            return -1;
        }

        return user.getId();
    }

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      请求对象
     * @return
     */
    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        if (userAccount.length() < 4) {
            return null;
        }
        if (userPassword.length() < 8) {
            return null;
        }
        // 账户不能包含特殊字符 正则表达式
        String validPattern = "^[a-zA-Z0-9]+$";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (!matcher.find()) {
            return null;
        }
        // 对密码进行加密处理
        String encryptPassword = DigestUtils.md5DigestAsHex((userPassword + SALT).getBytes());
        // 查询数据库
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        // 密码错误 or 用户不存在
        if (user == null) {
            log.info("user login failed, userAccount: {}, userPassword: {}", userAccount, userPassword);
            return null;
        }

        // 脱敏处理
        User safetyUser = getSafetyUser(user);

        // 记录用户的登录态 session cookie
        request.getSession().setAttribute(USER_LOGIN_STATE, safetyUser);

        // 限流策略...
        return safetyUser;
    }

    /**
     * 用户信息脱敏处理
     *
     * @param originalUser
     * @return
     */
    @Override
    public User getSafetyUser(User originalUser) {
        // 空处理
        if (originalUser == null) {
            return null;
        }

        User safetyUser = new User();
        safetyUser.setId(originalUser.getId());
        safetyUser.setUsername(originalUser.getUsername());
        safetyUser.setUserAccount(originalUser.getUserAccount());
        safetyUser.setAvatarUrl(originalUser.getAvatarUrl());
        safetyUser.setGender(originalUser.getGender());
        safetyUser.setPhone(originalUser.getPhone());
        safetyUser.setEmail(originalUser.getEmail());
        safetyUser.setUserRole(originalUser.getUserRole());
        safetyUser.setUserStatus(originalUser.getUserStatus());
        safetyUser.setCreateTime(originalUser.getCreateTime());
        return safetyUser;
    }
}




