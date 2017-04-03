package com.woven.grocerystore.controller;

import com.woven.grocerystore.base.BaseControllerIT;
import org.junit.Test;
import org.springframework.web.util.NestedServletException;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by eswaraprasadh on 03-04-2017.
 */
public class UserControllerIT extends BaseControllerIT {

    @Test
    public void testLogin() throws Exception {
        super.mockMvc.perform(get("/user/login")
                .param("userName", "admin")
                .param("password", "password"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/login"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test(expected = NestedServletException.class)
    public void testWrongRegistration() throws Exception {
        super.mockMvc.perform(post("/user/registration")
                .param("userName", "newuser")
                .param("password", "newpassword")
                .param("passwordConfirm", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("/user/registration"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    public void testRightRegistration() throws Exception {
        super.mockMvc.perform(post("/user/registration")
                .param("userName", "newuser")
                .param("password", "newpassword")
                .param("passwordConfirm", "newpassword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/hello"))
                .andExpect(model().hasNoErrors())
                .andDo(MockMvcResultHandlers.log());
    }
}
