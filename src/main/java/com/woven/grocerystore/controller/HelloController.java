package com.woven.grocerystore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/","/hello"})
    public String hello(HttpServletRequest request) {
        
        LOG.info(request.getServletPath());
        return "hello";
        
    }

}
