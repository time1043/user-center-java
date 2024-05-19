drop database user_center;
create database user_center;
use user_center;

drop table if exists user;
create table user
(
    id           bigint auto_increment primary key comment '唯一ID',
    username     varchar(255) comment '用户名',
    userAccount  varchar(255) comment '登录账号',
    avatarUrl    varchar(1024) comment '用户头像URL',
    gender       tinyint comment '用户性别',
    userPassword varchar(512) not null comment '用户密码',
    phone        varchar(128) comment '用户电话号码',
    email        varchar(512) comment '用户电子邮件',
    userStatus   int       default 0 comment '用户状态0为正常',
    createTime   timestamp default current_timestamp comment '创建时间',
    updateTime   timestamp default current_timestamp on update current_timestamp comment '更新时间',
    isDelete     tinyint   default 0 comment '逻辑删除标志',
    userRole     int       default 0 comment '用户角色 0是普通用户 1是管理员'
);

insert into user (username, useraccount, avatarurl, gender, userpassword, phone, email, userstatus,
                  createtime, updatetime, isdelete)
values ('AliceSmith', 'alice.smith', 'https://avatars.com/alice.jpg', 1, 'alicepass123', '+15551234567',
        'alice.smith@gmail.com', 0, current_timestamp, current_timestamp, 0),
       ('BobJohnson', 'bob.johnson', 'https://avatars.com/bob.jpg', 0, 'bobpass456', '+15551234568',
        'bob.johnson@yahoo.com', 0, current_timestamp, current_timestamp, 0),
       ('CharlieBrown', 'charlie.brown', 'https://avatars.com/charlie.jpg', 1, 'charliepass789', '+15551234569',
        'charlie.brown@outlook.com', 0, current_timestamp, current_timestamp, 0),
       ('DianaPrince', 'diana.prince', 'https://avatars.com/diana.jpg', 2, 'dianapass123', '+15551234570',
        'diana.prince@hotmail.com', 0, current_timestamp, current_timestamp, 0),
       ('EinsteinM', 'einstein.m', 'https://avatars.com/einstein.jpg', 1, 'einsteinpass456', '+15551234571',
        'einstein.m@icloud.com', 0, current_timestamp, current_timestamp, 0);
