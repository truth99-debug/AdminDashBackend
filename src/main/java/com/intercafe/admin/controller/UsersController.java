package com.intercafe.admin.controller;

import com.intercafe.admin.model.UserModel;
import com.intercafe.admin.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/admin")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/performLogin")
    private ResponseEntity<?> performLogin(@RequestBody() Map<? , ?> body){
        UserModel userModel = usersService.performLogin(String.valueOf(body.get("username")) , String.valueOf(body.get("password")));
        if (userModel != null){
            return ResponseEntity.ok(userModel);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"User was not found" );
        }
    }

    @GetMapping("/getAllUsers")
    private List<?> getAllUsers(){
        List<?> users = usersService.getAllUsers();
        if (!users.isEmpty()){
            return users;
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"No users Found" );
        }
    }
}
