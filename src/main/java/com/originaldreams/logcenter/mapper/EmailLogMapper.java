package com.originaldreams.logcenter.mapper;

import com.originaldreams.logcenter.entity.EmailLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmailLogMapper {
    String tableName = "email_log";


     @Select("SELECT id, type, recipients, title, content, sendDate FROM " + tableName + " WHERE id = #{id}")
     EmailLog getById(Integer Id);


     @Select("SELECT id, type, recipients, title, content, sendDate FROM " + tableName + " WHERE type = #{type}")
     EmailLog getByType(String type);


     @Select("SELECT id, type, recipients, title, content, sendDate FROM " + tableName + " WHERE recipients = #{recipients}")
     EmailLog getByRecipients(String recipients);


     @Select("<script>" +
             " SELECT * " +
             " FROM " +
             tableName +
             " <where> " +
             "<if test=\"entity != null and entity.type != null\"> AND type= #{entity.type}  </if>" +
             "<if test=\"entity != null and entity.title != null\"> AND title= #{entity.title}  </if>" +
             "<if test=\"entity != null and entity.recipients != null\"> AND recipients= #{entity.recipients}  </if>" +
             "<if test=\"startDate != null\"> AND sendDate &gt; #{startDate}  </if>" +
             "<if test=\"endDate != null\"> AND sendDate  &lt; #{endDate}  </if>" +
             " </where> " +
             " LIMIT  #{offset},#{rows}" +
             "</script>"
     )
     List<EmailLog> getListByCondition(Map params);


     @Select("SELECT id, type, recipients, title, content, sendDate FROM " + tableName)
     List<EmailLog> getAll();

     @Insert("INSERT INTO " + tableName + "(id, type, recipients, title, content, sendDate) VALUES (#{id}, #{type}, #{recipients}, #{title}, #{content}, #{sendDate})")
     @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
     Integer insert(EmailLog emailLog);

     @Delete("DELETE FROM " + tableName + " WHERE id = #{id}")
     Integer deleteById(Integer id);

     @Update("UPDATE " + tableName + " SET type=#{type}, recipients=#{recipients}, title=#{title}, content=#{content}, sendDate=#{sendDate} WHERE id = #{id}")
     Integer update(EmailLog emailLog);


}
