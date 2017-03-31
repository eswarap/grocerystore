package com.woven.grocerystore.service;

public interface SecurityService {
     
     String findLoggedInUserName();
     
     boolean login(String username, String password);
}
