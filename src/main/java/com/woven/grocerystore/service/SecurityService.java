package com.woven.grocerystore.service;

public interface SecurityService {
     
     String findLoggedInUserName();
     
     void login(String username, String password);
}
