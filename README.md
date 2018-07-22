﻿
## 提交用户登录log

#### URL
```
method:POST
signinLog/add
```
#### 参数

| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 登录时间 | signinDate | 是 | String | 2018-05-05 12:33:00 | 登录的时间 |
| 登录用户id | signinUserId | 是 | String | kabshkfbssefsefsebf | 登录的用户的id |
| 登录类型 | signinType | 是 | String | SIGNIN/SIGNOUT | 登录类型有两种：登入/登出 |
| 登录方式 | signinWay | 是 | String |  | 登录方式 |
| 登录时的ip | ip | 是 | String | 192.168.3.125 | 登录的用户的ip地址 |
| 登录设备 | signDevice | 是 | String |  | 登录的用户的设备 |



#### 返回结果
```
{
    code:200,
    Message:"SUCCESS"
}
```
#### 返回参数
| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 状态码 | code | 是 | Integer | 200 | 此字段是通信标识 |
| 系统消息 | Message | 是 | String | 欢迎登录 | 用户登录要记录的内容 |

#### 错误码
| 名称 | 描述 | 原因 | 解决方案 |
|:-----:|:-----:|:---:|:----:|
| 200 | 成功 |  |  | 
| 500 | 内部错误 |  |  | 


## 查找用户登录log

## 邮件发送相关log


#### URL 
