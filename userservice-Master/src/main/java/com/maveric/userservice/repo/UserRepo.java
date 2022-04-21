package com.maveric.userservice.repo;

import com.maveric.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepo extends MongoRepository<User,String> {
    User findByuserId(String userId);
    User findByemail(String emailId);

}
