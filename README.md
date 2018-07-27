#说明
+ 本文档所有接口应答均为如下格式：

  成功应答：
```json
{
    "success": 0,
    "data": 6,
    "message": null
}
```

  失败应答：
```json
{
    "success": 1,
    "data": null,
    "message": "不支持手机号登录"
}
```

+ 接口参数说明

参数名称|类型|说明
:---:|:---:|:---:
success|int|业务执行状态 0:成功;1:失败
data|Object|业务执行结果 参照具体应答的参数说明
message|String|业务执行失败时的错误信息

+ 注意
	1.本接口文档的所有接口均为Http请求格式，在使用接口时，应当先判断http返回码
	3.仅当http返回码为200且success=0时，说明业务处理成功。此时应关注data字段返回的业务数据
	4.当http返回码为其他，或http返回码200但success=1时，说明业务处理失败。此时应关注message字段给出的错误提示


## 1 登录日志
### 1.1 记录用户登录日志

+ 接口名称：记录用户登录日志
+ 接口地址：/signinLog/add
+ 请求方式：POST
+ 请求参数

| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 登录时间 | signinDate | 是 | String | 2018-05-05 12:33:00 | 登录的时间 |
| 登录用户id | signinUserId | 是 | String | kabshkfbssefsefsebf | 登录的用户的id |
| 登录类型 | signinType | 是 | String | SIGNIN/SIGNOUT | 登录类型有两种：登入/登出 |
| 登录方式 | signinWay | 是 | String |  | 登录方式 |
| 登录时的ip | ip | 是 | String | 192.168.3.125 | 登录的用户的ip地址 |
| 登录设备 | signDevice | 是 | String |  | 登录的用户的设备 |

+ 应答

| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 状态码 | code | 是 | Integer | 200 | 此字段是通信标识 |
| 系统消息 | Message | 是 | String | SUCCESS | 程序成功以及异常信息 |

+ 响应示例
```
{
    code:200,
    Message:"SUCCESS"
}
```


### 1.2 查找用户登录日志
+ 接口名称：查找用户登录日志
+ 接口地址：/signinLog/list
+ 请求方式：GET
+ 请求

  
## 2 邮件日志
### 2.1 记录邮件发送日志
+ 接口名称：记录邮件发送日志
+ 接口地址：/emailLog/add
+ 请求方式：POST
+ 请求参数

| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 邮件发送类型 | type | 是 | String |  | 邮件发送类型 |
| 收件人 | recipients | 是 | String | donwilliamlone@gmail.com | 收件人的邮箱地址 |
| 标题 | title | 是 | String | "邮箱验证" |  |
| 内容 | content | 是 | String | 请您立刻检出邮件内的链接 |  |
| 发送时间 | sendDate | 是 | String | 2018-05-01 12:21:00 | 发送的时间 |

+ 返回参数

| 字段名 | 变量名 | 必填 | 类型 | 示例值 | 描述 |
|:-----:|:-----:|:---:|:----:|:-----:|:---:|
| 状态码 | code | 是 | Integer | 200 | 此字段是通信标识 |
| 系统消息 | Message | 是 | String | SUCCESS | 程序成功以及异常信息 |

+ 响应示例
```
{
    code:200,
    Message:"SUCCESS"
}
```

### 2.2 查找邮件发送日志
+ 接口名称：查找用户登录日志
+ 接口地址：/signinLog/list
+ 请求方式：GET
+ 请求参数
 
