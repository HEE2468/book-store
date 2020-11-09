package com.sww.bank_book.login.controller;

import com.sww.bank_book.login.entity.User;
import com.sww.bank_book.login.service.UserService;

import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author HEE
 * @date 2019/12/9
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject<User> login(String username, String password, HttpSession session) {
        User result = userService.login(username, password);
        JSONObject<User> jsonObject = new JSONObject<>();
        if (result != null) {
            session.setAttribute("username", result.getUsername());
            session.setAttribute("password", result.getPassword());
            jsonObject.setData(result);
            jsonObject.setCode(200);
            jsonObject.setMsg("SUCCESS");
        } else {
            jsonObject.setCode(504);
            jsonObject.setMsg("FAIL");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public JSONObject<User> insertUser(@RequestBody User user){

        Integer insertNum = userService.insertUser(user);
        if(insertNum == -1){
            return new JSONObject<>(insertNum,"注册失败!");
        }else if(insertNum == 2){
            return new JSONObject<>(insertNum,"用户名已存在!");
        }else{
            return new JSONObject<>(insertNum,"注册成功!");
        }

    }

}
