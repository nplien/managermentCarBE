package com.gara.service;


import com.gara.dto.ResUserDto;
import com.gara.model.UserModel;

import java.util.List;

public interface UserService {

	UserModel loginPassword(String username, String password) throws Exception;

}
