package com.originaldreams.logcenter.controller;

import com.originaldreams.common.response.MyResponse;
import com.originaldreams.common.response.MyServiceResponse;
import com.originaldreams.logcenter.entity.EmailLog;
import com.originaldreams.logcenter.entity.SigninLog;
import com.originaldreams.logcenter.service.EmailLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emailLog")
public class EmailLogController {
    private Logger logger = LoggerFactory.getLogger(EmailLogController.class);

    @Resource
    private EmailLogService emailLogService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity add(EmailLog entity){
        MyServiceResponse response =new MyServiceResponse();
        try{
            Integer rows = emailLogService.insert(entity);
            response.setSuccess(MyServiceResponse.SUCCESS_CODE_SUCCESS);
//            response.setMessage("SUCCESS");
            logger.info("新增了邮件发送日志:"+rows+"条\t id:"+entity.getId());
        }catch(Exception e){
            e.printStackTrace();
            return MyResponse.serverError();
        }
        return MyResponse.ok(response);
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity list(EmailLog log,String startDate,String endDate,Integer page_num,Integer page_size) {
        Map<String, Object> params = new HashMap<>();
        MyServiceResponse response = new MyServiceResponse();
        if (page_num != null || page_size != null) {
            Integer offset = (page_num - 1) * page_size;
            params.put("offset", offset);
            params.put("rows", page_size);
        } else {
            params.put("offset", 0);
            params.put("rows", 10);
        }
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("entity", log);
        response.setData(emailLogService.getListByCondition(params));
        return MyResponse.ok(response);
    }


    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    ResponseEntity getById(Integer id){
        EmailLog result = emailLogService.getById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/getByType",method = RequestMethod.GET)
    ResponseEntity getByType(String type){
        EmailLog result = emailLogService.getByType(type);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }


    @RequestMapping(value = "/getByRecipients",method = RequestMethod.GET)
    ResponseEntity getByRecipients(String recipients){
        EmailLog result = emailLogService.getByRecipients(recipients);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }






    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResponseEntity getAll(){
        List<EmailLog> result = emailLogService.getAll();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResponseEntity insert(EmailLog emailLog){
        Integer result = emailLogService.insert(emailLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResponseEntity deleteById(Integer id){
        Integer result = emailLogService.deleteById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResponseEntity update(EmailLog emailLog){
        Integer result = emailLogService.update(emailLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

}
