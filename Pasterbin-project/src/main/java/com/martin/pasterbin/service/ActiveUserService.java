package com.martin.pasterbin.service;

import com.martin.pasterbin.models.User;
import com.martin.pasterbin.repostitories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActiveUserService {
    private User activeUser=null;
    private Integer userId = null;

    @Autowired
    UserRepository userRepository;

    public void setActiveUser(User user){
        this.activeUser=user;
        this.userId=user.getId();
    }

    public void setInactiveUser(){
        this.activeUser=null;
        this.userId=null;
    }

    public int getActiveUserId(){
        return userId;
    }
    public String getActiveUserName() {
        if(activeUser!=null){
            return activeUser.getName();
        }
            return "гость";

    }
    public User getActiveUser(){
        return this.activeUser;
    }
}
