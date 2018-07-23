package com.originaldreams.logcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.entity.EmailLog;
import com.originaldreams.logcenter.mapper.EmailLogMapper;
import java.util.List;

@Service
public class EmailLogService {
    @Autowired
    private EmailLogMapper emailLogMapper;

    public EmailLog getById(Integer id){

        return emailLogMapper.getById(id);
    }

    public EmailLog getByType(String type){
        return emailLogMapper.getByType(type);
    }

    public EmailLog getByRecipients(String recipients){
        return emailLogMapper.getByRecipients(recipients);
    }




    public List<EmailLog> getAll(){
        return emailLogMapper.getAll();
    }

    public Integer insert(EmailLog emailLog){
        return emailLogMapper.insert(emailLog);
    }

    public Integer deleteById(Integer id){
        return emailLogMapper.deleteById(id);
    }

    public Integer update(EmailLog emailLog){
        return emailLogMapper.update(emailLog);
    }


}
