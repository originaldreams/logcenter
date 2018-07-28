package com.originaldreams.logcenter.service;

import com.originaldreams.logcenter.entity.TableMaintenance;
import com.originaldreams.logcenter.mapper.TableMaintenanceMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.entity.SigninLog;
import com.originaldreams.logcenter.mapper.SigninLogMapper;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableTransactionManagement
@Service
public class SigninLogService {
    @Autowired
    private SigninLogMapper signinLogMapper;

    @Autowired
    private TableMaintenanceMapper maintenanceMapper;

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


    @Transactional
    public Integer createNewTableByDate(TableMaintenance maintenance, String days){
        signinLogMapper.createNewTableByDate(days);
        maintenance.setTable_create_day(days);
        maintenance.setTable_name(maintenance.getTable_type()+"_"+days);
        maintenanceMapper.update(maintenance);
        if(days.equals("2018-07-30")){
//            throw new NullPointerException();
        }
        return 0;
    }

}
