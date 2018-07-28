package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.SigninLog;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SigninLogMapper {
     String tableName = "signin_log";

     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName + " WHERE id = #{id}")
     SigninLog getById(Integer Id);


     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName + " WHERE signinType = #{signinType}")
     SigninLog getBySigninType(String signinType);


     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName)
     List<SigninLog> getAll();


     @Select("<script>" +
             " SELECT * " +
             " FROM " +
             tableName +
             " <where> " +
             "<if test=\"entity != null and entity.signinType != null\"> AND signinType= #{entity.signinType}  </if>" +
             "<if test=\"entity != null and entity.signinWay != null\"> AND signinWay= #{entity.signinWay}  </if>" +
             "<if test=\"entity != null and entity.ip != null\"> AND ip= #{entity.ip}  </if>" +
             "<if test=\"entity != null and entity.signinUserId != null\"> AND signinUserId= #{entity.signinUserId}  </if>" +
             "<if test=\"startDate != null\"> AND signinDate &gt; #{startDate}  </if>" +
             "<if test=\"endDate != null\"> AND signinDate  &lt; #{endDate}  </if>" +
             " </where> " +
             " LIMIT  #{offset},#{rows}" +
             "</script>"
     )
     List<SigninLog> getListByCondition(Map params);

     @Insert("INSERT INTO " + tableName + "(id, signinDate, signinUserId, signinType, signinWay, ip, signDevice) VALUES (#{id}, #{signinDate}, #{signinUserId}, #{signinType}, #{signinWay}, #{ip}, #{signDevice})")
     @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
     Integer insert(SigninLog signinLog);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);

     @Update("UPDATE " + tableName + " SET signinDate=#{signinDate}, signinUserId=#{signinUserId}, signinType=#{signinType}, signinWay=#{signinWay}, ip=#{ip}, signDevice=#{signDevice} WHERE id = #{id}")
     Integer update(SigninLog signinLog);

    @Update("CREATE TABLE `"+tableName+"_"+"${days}` (" +
            "  `id` int(10) NOT NULL AUTO_INCREMENT," +
            "  `signinDate` varchar(30) DEFAULT NULL COMMENT '登录时间'," +
            "  `signinUserId` int(10) NOT NULL COMMENT '登录用户id'," +
            "  `signinType` varchar(10) DEFAULT 'SIGNIN' COMMENT '登录类型'," +
            "  `signinWay` varchar(255) DEFAULT NULL COMMENT '登录方式'," +
            "  `IP` varchar(15) DEFAULT NULL COMMENT '登录时的ip'," +
            "  `signDevice` varchar(255) DEFAULT NULL COMMENT '登录设备'," +
            "  PRIMARY KEY (`id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;")
    Integer createNewTableByDate(@Param("days") String days);


}
