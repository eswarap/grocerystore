package com.woven.grocerystore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.woven.grocerystore.dto.UserDto;
import com.woven.grocerystore.jpa.Pagination;
import com.woven.grocerystore.jpa.User;
import com.woven.grocerystore.mapper.GroceryMapper;
import com.woven.grocerystore.service.RoleService;
import com.woven.grocerystore.service.SecurityService;
import com.woven.grocerystore.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
    
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "user/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.save(userForm);

        securityService.login(userForm.getUserName(), userForm.getPasswordConfirm());

        return "redirect:/hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        
        
        return "user/login";
    }
    
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView list(Model model,@RequestParam(value="page",required=false) Integer page) {
        
        int count = userService.count().intValue();
        int endpage =  (count+Pagination.SIZE-1)/Pagination.SIZE;
        int startpage = 1;
                
        int first = page == 1 ? 0 : ( page -1 )* Pagination.SIZE;
        int max = first + Pagination.SIZE;
        max = max > count ? count :max;
        Pagination pagination = new Pagination(first,max);
        List<UserDto> userList = userService.list(pagination); 
        model.addAttribute("startpage",startpage);
        model.addAttribute("endpage",endpage);
        model.addAttribute("users",userList);
        return new ModelAndView("user/list");
    }
    
    
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String remove(@RequestParam("userId") Long userId) {
        
        this.userService.delete(userId);
    	return "redirect:/user/list?page=1";
    
    }

}
