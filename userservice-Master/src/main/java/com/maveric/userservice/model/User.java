package com.maveric.userservice.model;

import com.maveric.userservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document(collection = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    @NotEmpty(message = "Please provide First Name")
    @Size(min = 2,message = "Length of first name should be more than 2 character ")
    private String firstName;
    private String middleName;
    @NotEmpty(message = "Please provide Last Name")
    @Size(min = 2,message = "Length of Last name should be more than 2 character ")
    private String lastName;
    @NotEmpty(message = "Please provide phone number")
    @Size(min = 10,max=10,message = "Length of phone Number should  be 10")
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    @NotEmpty(message = "Please provide address")
    private String address;
    @NotEmpty(message = "Please provide EmployeeId")
    private String employeeNumber;
    private String bloodGroup;
    @NotBlank(message = "email cannot be null")
    @Email(message = "Please provide valid email adress")
    private String email;
    @NotBlank(message = "password cannot be null")
    private String password;

    public User(String firstName, String middleName, String lastName, String phoneNumber, LocalDate dateOfBirth, Gender gender, String address, String employeeNumber, String bloodGroup, String email, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.employeeNumber = employeeNumber;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.password = password;
    }
}
