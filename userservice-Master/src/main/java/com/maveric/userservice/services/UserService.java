package com.maveric.userservice.services;


import com.maveric.userservice.dto.Userdto;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {
	List<UserResponse> getUsers(Integer page,Integer pagesize);
	UserResponse getUserDetails(String userId);
	UserResponse getUserDetailsByEmail(String emailId);
    UserResponse createUser(Userdto user);
    UserResponse updateUser(String userId, Userdto updateUser);
	String deleteUser(String userId);
     
     
}
