package com.originaldreams.logcenter.service;

import com.originaldreams.logcenter.entity.LogonLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.originaldreams.logcenter.mapper.LogonLogMapper1;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.Map;

@EnableTransactionManagement
@Service
public class LogonLogService1 {
    @Autowired
    private LogonLogMapper1 logonLogMapper;

    public List<LogonLog> getListByCondition(Map params){
        return logonLogMapper.getListByCondition(params);
    }


//    @Transactional
//    public Integer createNewTableByDate(TableMaintenance maintenance, String days){
//        logonLogMapper.createNewTableByDate(days);
//        maintenance.setTable_create_day(days);
//        maintenance.setTable_name(maintenance.getTable_type()+"_"+days);
//        maintenanceMapper.update(maintenance);
//        if(days.equals("2018-07-30")){
//        }
//        return 0;
//    }

}
