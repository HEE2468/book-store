package com.sww.bank_book.center.controller;

import com.sww.bank_book.center.entity.UserManager;
import com.sww.bank_book.center.service.UserManagerService;
import com.sww.bank_book.utils.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HEE
 * @date 2020/10/12
 * @description
 */
@RestController
@RequestMapping("/center")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping(value = "/findUserInfos")
    public JSONObject<UserManager> findUserInfos(@RequestBody UserManager userManager){

        UserManager newUserManager = userManagerService.findUserInfos(userManager.getUserId());
        if(newUserManager !=null){
            return new JSONObject<>(null,newUserManager,200,"数据查询成功!");
        }
        return new JSONObject<>(null,null,504,"未查询到对应数据!");
    }

    @RequestMapping(value = "/updateUserInfos")
    public JSONObject<UserManager> updateUserInfos(@RequestBody UserManager userManager){

        Integer updateNum = userManagerService.updateUserInfos(userManager);
        if(updateNum != 0){
            return new JSONObject<>(null,null,200,"数据更新成功!");
        }
        return new JSONObject<>(null,null,504,"数据有误!");
    }


    @RequestMapping(value = "/findUserPasswordById")
    public JSONObject<UserManager> findUserPasswordById(@RequestBody UserManager userManager){

        Integer checkNum = userManagerService.findUserPasswordById(userManager);
        if(checkNum == 1){
            return new JSONObject<>(null,null,200,"successfully!");
        }
        return new JSONObject<>(null,null,504,"failure");
    }

    /**
     * @author: shenww
     * @description: 上传用户头像
     * @param: [file]
     * @date: 2020/10/16
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/uploadImages",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> uploadImages(MultipartFile file) throws FileNotFoundException {
        Map<String,String> map = new HashMap<>();
        String result = userManagerService.uploadFile(file);
        map.put("imgSrc",result);
        return map;
    }
}
