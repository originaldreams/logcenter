package com.originaldreams.logcenter.controller;

import com.originaldreams.logcenter.entity.LogonLog;
import com.originaldreams.logcenter.service.LogonLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/logonLog")
public class LogonLogController {
    private Logger logger = LoggerFactory.getLogger(LogonLogController.class);

    @Resource
    private LogonLogService logonLogService;

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    ResponseEntity getById(Integer id){
        LogonLog result = logonLogService.getById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/getByUserId",method = RequestMethod.GET)
    ResponseEntity getByUserId(Integer userId){
        LogonLog result = logonLogService.getByUserId(userId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }


    @RequestMapping(value = "/getByType",method = RequestMethod.GET)
    ResponseEntity getByType(Integer type){
        LogonLog result = logonLogService.getByType(type);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }






    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    ResponseEntity getAll(){
        List<LogonLog> result = logonLogService.getAll();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ResponseEntity insert(LogonLog logonLog){
        Integer result = logonLogService.insert(logonLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.DELETE)
    ResponseEntity deleteById(Integer id){
        Integer result = logonLogService.deleteById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResponseEntity update(LogonLog logonLog){
        Integer result = logonLogService.update(logonLog);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

}
