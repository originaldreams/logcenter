package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.LogonLog;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author 董晨龙
 * @date 2018-08-15 10:03:58
 */
@Mapper
public interface LogonLogMapper1 {
     String tableName = "logon_log";

     @Select("<script>" +
             " SELECT * " +
             " FROM " +
             tableName +
             " <where> " +
             "<if test=\"entity != null and entity.type != null\"> AND type= #{entity.type}  </if>" +
             "<if test=\"entity != null and entity.way != null\"> AND way= #{entity.way}  </if>" +
             "<if test=\"entity != null and entity.ip != null\"> AND ip= #{entity.ip}  </if>" +
             "<if test=\"entity != null and entity.userId != null\"> AND userId= #{entity.userId}  </if>" +
             "<if test=\"startDate != null\"> AND createDatetime &gt; #{startDate}  </if>" +
             "<if test=\"endDate != null\"> AND createDatetime  &lt; #{endDate}  </if>" +
             " </where> " +
             " LIMIT  #{offset},#{rows}" +
             "</script>"
     )
     List<LogonLog> getListByCondition(Map params);

    @Update("CREATE TABLE `"+tableName+"_"+"${days}` (" +
            "  `id` int(10) NOT NULL AUTO_INCREMENT," +
            "  `createDatetime` varchar(30) DEFAULT NULL COMMENT '登录时间'," +
            "  `userId` int(10) NOT NULL COMMENT '登录用户id'," +
            "  `type` varchar(10) DEFAULT 'SIGNIN' COMMENT '登录类型'," +
            "  `way` varchar(255) DEFAULT NULL COMMENT '登录方式'," +
            "  `IP` varchar(15) DEFAULT NULL COMMENT '登录时的ip'," +
            "  `deviceId` varchar(255) DEFAULT NULL COMMENT '登录设备'," +
            "  PRIMARY KEY (`id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    Integer createNewTableByDate(@Param("days") String days);
}
