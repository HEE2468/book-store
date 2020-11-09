package com.sww.bank_book.center.service.impl;

import com.sww.bank_book.center.dao.UserManagerDao;
import com.sww.bank_book.center.entity.UserManager;
import com.sww.bank_book.center.service.UserManagerService;
import com.sww.bank_book.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserManagerDao userManagerDao;

    @Override
    public UserManager findUserInfos(String userId) {
        return userManagerDao.findUserInfos(userId);
    }

    @Override
    public Integer updateUserInfos(UserManager userManager) {
        if(userManager.getUserId()!=null){
            if("".equals(userManager.getNewPassword())){
                userManager.setNewPassword(null);
            }else {
                userManager.setNewPassword(MD5Util.getMD5_32(userManager.getNewPassword()));
            }
            UserManager newUser = userManagerDao.findUserInfos(userManager.getUserId());
            if(newUser!=null){
                return userManagerDao.updateUserInfos(userManager);
            }else {
                // 用户未注册
                return -2;
            }

        }else{
            // 用户未登录
            return -1;
        }

    }

    @Override
    public Integer findUserPasswordById(UserManager userManager) {
        if(userManager.getUserId()!=null){
            UserManager newUser = userManagerDao.findUserPasswordById(userManager.getUserId());
            if(newUser.getOldPassword()!=null && newUser.getOldPassword().equals(MD5Util.getMD5_32(userManager.getOldPassword()))) {
                return 1;
            }else{
                return 0;
            }
        }else {
            // 用户未登录
            return -1;
        }

    }

    @Override
    public String uploadFile(MultipartFile file) throws FileNotFoundException {
        System.out.println("3");
        File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(rootPath.getAbsolutePath(), "static/upload/userPhoto");
        String fileName = file.getOriginalFilename();
        String filePath = "upload/userPhoto";
        File dest = new File(upload.getAbsolutePath() +"/"+fileName);
        try {
            file.transferTo(dest);
            return filePath + "/"+fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
