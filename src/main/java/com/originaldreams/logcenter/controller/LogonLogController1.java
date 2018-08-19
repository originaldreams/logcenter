package com.originaldreams.logcenter.controller;
import com.originaldreams.logcenter.service.LogonLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/logonLog")
public class LogonLogController1 {
    private Logger logger = LoggerFactory.getLogger(LogonLogController1.class);

    @Resource
    private LogonLogService logonLogService;



//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public ResponseEntity list(LogonLog log, String startDate, String endDate, Integer page_num, Integer page_size){
//        Map<String,Object> params = new HashMap<>();
//        MyServiceResponse response =new MyServiceResponse();
//        if(page_num!=null||page_size!=null){
//            Integer offset=(page_num-1)*page_size;
//            params.put("offset",offset);
//            params.put("rows",page_size);
//        }else{
//            params.put("offset",0);
//            params.put("rows",10);
//        }
//        params.put("startDate",startDate);
//        params.put("endDate",endDate);
//        params.put("entity",log);
//        response.setData(logonLogService.getListByCondition(params));
//        return MyResponse.ok(response);
//    }
}