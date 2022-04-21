package com.maveric.userservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {

    @NotEmpty(message = "Please provide first Name")
    @Size(min = 2,message = "Length of first name should be more than 2 character ")
    private String firstName;
    private String middleName;
    @NotEmpty(message = "Please provide last name")
    @Size(min = 2,message = "Length of Last name should be more than 2 character ")
    private String lastName;
    @NotEmpty(message = "Please provide phone number")
    @Size(min = 10,max=10,message = "Length of phone number should  be 10")
    private String phoneNumber;
    private LocalDate dateOfBirth;

    private Gender gender;
    @NotEmpty(message = "Please provide address")
    private String address;
    @NotEmpty(message = "Please provide employeeid")
    private String employeeNumber;
    private String bloodGroup;
    @NotBlank(message = "email cannot be null")
    @Email(message = "Please provide valid email address")
    private String email;
    @NotBlank(message = "password cannot be null")
    private String password;
}
