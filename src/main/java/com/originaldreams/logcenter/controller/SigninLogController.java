package com.originaldreams.logcenter.controller;

import com.originaldreams.logcenter.entity.SigninLog;
import com.originaldreams.logcenter.service.SigninLogService;
import com.sun.javafx.collections.MappingChange;
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
@RequestMapping("/signinLog")
public class SigninLogController {
    private Logger logger = LoggerFactory.getLogger(SigninLogController.class);

    @Resource
    private SigninLogService signinLogService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity add(SigninLog entity){
        Map<String,Object> result = new HashMap<>();
        try{
            Integer rows = signinLogService.insert(entity);
            result.put("code",200);
            result.put("message","SUCCESS");
            logger.info("新增了登陆日志:"+rows+"条\t id:"+entity.getId());
        }catch(Exception e){
            result.put("code",500);
            result.put("message",e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/getLogList",method = RequestMethod.GET)
    public ResponseEntity getLogList(String logContent){
        Map<String,Object> result = new HashMap<>();

        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }


    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    ResponseEntity getById(Integer id){
        SigninLog result = signinLogService.getById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/getBySigninType",method = RequestMethod.GET)
    ResponseEntity getBySigninType(String signinType){
        SigninLog result = signinLogService.getBySigninType(signinType);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }






    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResponseEntity getAll(){
        List<SigninLog> result = signinLogService.getAll();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResponseEntity insert(SigninLog signinLog){
        Integer result = signinLogService.insert(signinLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResponseEntity deleteById(Integer id){
        Integer result = signinLogService.deleteById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResponseEntity update(SigninLog signinLog){
        Integer result = signinLogService.update(signinLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

}
