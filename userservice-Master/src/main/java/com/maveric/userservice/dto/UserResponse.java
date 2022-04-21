package com.maveric.userservice.dto;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private String employeeNumber;
    private String bloodGroup;
    private String email;
}
