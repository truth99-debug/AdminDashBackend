package com.intercafe.admin.service;

import com.intercafe.admin.model.UserModel;
import com.intercafe.admin.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsersService {
    Logger logger = LoggerFactory.getLogger(UsersService.class);
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserModel performLogin(String username , String password){
        try {
            UserModel userModel = usersRepository.performLogin(username , password);
            logger.info("User in question = {} " , userModel);
           return usersRepository.performLogin(username,password);
        }catch (Exception e){
            logger.error("User not found ={}" , e.getMessage());
            return null;
        }
    }

    public List<UserModel> getAllUsers(){
        return  usersRepository.getAllUsers();
    }
}
