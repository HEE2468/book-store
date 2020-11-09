package com.sww.bank_book.center.service;

import com.sww.bank_book.center.entity.UserManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

/**
 * @author HEE
 * @date 2020/10/11
 * @description
 */
public interface UserManagerService {

    UserManager findUserInfos(String userId);

    Integer updateUserInfos(UserManager userManager);

    Integer findUserPasswordById(UserManager userManager);

    String uploadFile(MultipartFile file) throws FileNotFoundException;
}
