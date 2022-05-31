package com.gara.service;

import com.gara.dao.UserDao;
import com.gara.dto.ResUserDto;
import com.gara.model.UserModel;
import com.gara.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserModel loginPassword(String username, String password) throws Exception {
        String passwordEncrypt = StringUtils.encryptMD5(StringUtils.encryptMD5(password));
        logger.info("loginPassword - passwordEncrypt : " + passwordEncrypt);
        UserModel response = userDao.getExistedUser(username, passwordEncrypt);
        logger.info("response loginPassword: " + response);
        return response;
    }

}
