package com.woven.grocerystore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HelloController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/","/hello"})
    public String hello(HttpServletRequest request) {
        
        LOG.info(request.getServletPath());
        return "hello";
        
    }

}
