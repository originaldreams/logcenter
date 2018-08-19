package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.LogonLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface LogonLogMapper {
    String tableName = "logon_log";


     @Select("SELECT id, userId, type, way, ip, deviceId, createTime FROM " + tableName + " WHERE id = #{id}")
     LogonLog getById(Integer Id);


     @Select("SELECT id, userId, type, way, ip, deviceId, createTime FROM " + tableName + " WHERE userId = #{userId}")
     LogonLog getByUserId(Integer userId);


     @Select("SELECT id, userId, type, way, ip, deviceId, createTime FROM " + tableName + " WHERE type = #{type}")
     LogonLog getByType(Integer type);



     @Select("SELECT id, userId, type, way, ip, deviceId, createTime FROM " + tableName)
     List<LogonLog> getAll();

     @Insert("INSERT INTO " + tableName + "(userId, type, way, ip, deviceId, createTime) VALUES (#{userId}, #{type}, #{way}, #{ip}, #{deviceId}, #{createTime})")
     @Options(useGeneratedKeys = true)
     Integer insert(LogonLog logonLog);



     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);

     @Update("UPDATE " + tableName + " SET userId=#{userId}, type=#{type}, way=#{way}, ip=#{ip}, deviceId=#{deviceId}, createTime=#{createTime} WHERE id = #{id}")
     Integer update(LogonLog logonLog);


}
