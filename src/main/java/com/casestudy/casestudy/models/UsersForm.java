package com.casestudy.casestudy.models;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class UsersForm {
    private Long id;

    private String firstName;
    private String lastName;

    private String nickName;

    private Float price;

    private Timestamp birthday;

    @NotEmpty(message = "Email must be not empty")
    @Email(message = "Invalid email form")
    private String email;

    @NotEmpty(message = "Username must be not empty")
    private String userName;

    @NotEmpty(message = "Password must be not empty")
    @Size(min = 6, max = 30, message = "Password from 6 to 30 characters")
    private String password;


    private Status status;


    private Rank rank;


    private Role role;

    private MultipartFile avatar;


}
