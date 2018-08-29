package com.originaldreams.logcenter.service;

import com.originaldreams.common.response.MyServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.entity.SMSLog;
import com.originaldreams.logcenter.mapper.SMSLogMapper;
import java.util.List;

@Service
public class SMSLogService {
    @Autowired
    private SMSLogMapper smsLogMapper;

    public MyServiceResponse insert(SMSLog smsLog){
        smsLogMapper.insert(smsLog);
        return new MyServiceResponse(smsLog.getId());
    }


    public SMSLog getById(Integer id){

        return smsLogMapper.getById(id);
    }

    public SMSLog getByPhone(String phone){
        return smsLogMapper.getByPhone(phone);
    }

    public SMSLog getByType(Integer type){
        return smsLogMapper.getByType(type);
    }




    public List<SMSLog> getAll(){
        return smsLogMapper.getAll();
    }


    public Integer deleteById(Integer id){
        return smsLogMapper.deleteById(id);
    }

    public Integer update(SMSLog smsLog){
        return smsLogMapper.update(smsLog);
    }


}
