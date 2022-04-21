package com.maveric.userservice.services;

import com.maveric.userservice.dto.Userdto;
import com.maveric.userservice.dto.UserResponse;
import com.maveric.userservice.enums.Gender;
import com.maveric.userservice.exception.GenderNotValid;
import com.maveric.userservice.exception.UserDetailsNotPresent;
import com.maveric.userservice.exception.UserEmailAlreadyExist;
import com.maveric.userservice.exception.UserNotExistsException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
@LoadBalanced

 @Override
    public UserResponse createUser(Userdto userdto) {

    if(!(userdto.getGender().equals(Gender.MALE)||userdto.getGender().equals(Gender.FEMALE))) {
        log.info("provide valid gender");
        throw new GenderNotValid("Please provide valid gender");
    }
    if(userRepo.findByemail(userdto.getEmail())!=null){
        log.info("Provide different email");
        throw new UserEmailAlreadyExist("Try with different email id");
    }
    log.info("user is getting saved to repo");
        return setUserResponse((userRepo.save(setUser(userdto))));

    }
	
	  @Override
    public List<UserResponse> getUsers() {
        
        List<User> userList=userRepo.findAll();
        List<UserResponse> userResponseList=new ArrayList<>();
        if(userList.size()==0){
            log.info("Users not found");
            throw new UserDetailsNotPresent("No User Present at this time");
        }

        for(User user:userList){
            userResponseList.add(setUserResponse(user));
        }
        log.info("Users fetched successfully");
        return userResponseList;
    }

 @Override
    public UserResponse getUserDetails(String userId) {
    User user=userRepo.findByuserId(userId);
        if (user == null){
            log.info("User details not found");
            throw new UserNotExistsException("User with id not Present");
        }
        log.info("User details fetched successfully");
        return setUserResponse(user);
    }


    @Override
    public UserResponse updateUser(String userId, Userdto updateUser) {

        if(userRepo.findByuserId(userId)==null){
            log.info("Can't be updated ");
            throw new UserNotExistsException("User cannot be updated, user not Present");
        }
        log.info("user updating in repo");
        return setUserResponse(userRepo.save(new User(userId,updateUser.getFirstName(),updateUser.getMiddleName(),updateUser.getLastName(),updateUser.getPhoneNumber(),
                updateUser.getDateOfBirth(),updateUser.getGender(),updateUser.getAddress(),updateUser.getEmployeeNumber(),
                updateUser.getBloodGroup(),updateUser.getEmail(),bCryptPasswordEncoder.encode(updateUser.getPassword()))));

    }
	
	@Override
    public String deleteUser(String userId) {
        if(userRepo.findByuserId(userId)==null){
            log.info("user not found ,can't be deleted");
            throw new UserNotExistsException("User cannot be deleted, user not Present");
        }
         userRepo.deleteById(userId);
        log.info("user deleted successfully");
         return "User successfully deleted";
    }

@Override
    public UserResponse getUserDetailsByEmail(String emailId) {
        User user=userRepo.findByemail(emailId);
        if(user==null)
        {
            log.info("User not found by email Id");
            throw new UserNotExistsException("User not found with email Id: "+emailId);
        }
        log.info("user found successfully");
        return setUserResponse(user);
    }
    

    

    public UserResponse setUserResponse(User user){
        return new UserResponse(user.getUserId(),user.getFirstName(),user.getMiddleName(),
                user.getLastName(),user.getPhoneNumber(),user.getDateOfBirth(),user.getGender(),
                user.getAddress(),user.getEmployeeNumber(),user.getBloodGroup(),user.getEmail());
    }

    public User setUser(Userdto userdto){
    return new User(userdto.getFirstName(),userdto.getMiddleName(),userdto.getLastName(),userdto.getPhoneNumber(),
            userdto.getDateOfBirth(),userdto.getGender(),userdto.getAddress(),userdto.getEmployeeNumber(),
            userdto.getBloodGroup(),userdto.getEmail(),bCryptPasswordEncoder.encode(userdto.getPassword()));
    }

}
