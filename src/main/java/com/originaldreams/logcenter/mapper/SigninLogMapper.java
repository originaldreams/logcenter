package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.SigninLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface SigninLogMapper {
    String tableName = "signinLog";


     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName + " WHERE id = #{id}")
     SigninLog getById(Integer Id);


     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName + " WHERE signinType = #{signinType}")
     SigninLog getBySigninType(String signinType);



     @Select("SELECT id, signinDate, signinUserId, signinType, signinWay, ip, signDevice FROM " + tableName)
     List<SigninLog> getAll();

     @Insert("INSERT INTO " + tableName + "(id, signinDate, signinUserId, signinType, signinWay, ip, signDevice) VALUES (#{id}, #{signinDate}, #{signinUserId}, #{signinType}, #{signinWay}, #{ip}, #{signDevice})")
     Integer insert(SigninLog signinLog);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);

     @Update("UPDATE " + tableName + " SET signinDate=#{signinDate}, signinUserId=#{signinUserId}, signinType=#{signinType}, signinWay=#{signinWay}, ip=#{ip}, signDevice=#{signDevice} WHERE id = #{id}")
     Integer update(SigninLog signinLog);


}
