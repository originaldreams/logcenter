package com.originaldreams.logcenter.controller;

import com.originaldreams.logcenter.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        String str = null;
        ResponseEntity<String> responseEntity  = restTemplate.getForEntity("http://UserManagerCenter/user/getAll",String.class);
        str = responseEntity.getBody();
        logger.info("test========" + str);
        return str;

    }


}
