package com.originaldreams.logcenter.service;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.entity.SigninLog;
import com.originaldreams.logcenter.mapper.SigninLogMapper;
import java.util.List;
import java.util.Map;

@Service
public class SigninLogService {
    @Autowired
    private SigninLogMapper signinLogMapper;

    public SigninLog getById(Integer id){

        return signinLogMapper.getById(id);
    }

    public SigninLog getBySigninType(String signinType){
        return signinLogMapper.getBySigninType(signinType);
    }

    public List<SigninLog> getAll(){
        return signinLogMapper.getAll();
    }

    public Integer insert(SigninLog signinLog){
        return signinLogMapper.insert(signinLog);
    }

    public Integer deleteById(Integer id){
        return signinLogMapper.deleteById(id);
    }

    public Integer update(SigninLog signinLog){
        return signinLogMapper.update(signinLog);
    }

    public List<SigninLog> getListByCondition(Map params){
        return signinLogMapper.getListByCondition(params);
    }

}
