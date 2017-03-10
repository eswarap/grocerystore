package com.woven.grocerystore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HelloController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/hello")
    public ModelAndView hello() {

        LOG.info("Returning hello view");

        return new ModelAndView("hello.jsp");
    }


}
