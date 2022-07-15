package com.training.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 8,message = "first name should have more than 2 characters and less than 8 character")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 64,message = "first name should have more than 2 characters and less than 64 character")
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 64,message = "email should have more than 2 characters and less than 64 character")
    @Email
//    @Pattern(regexp="^(.+)@(\\\\S+)$", message = "Email is not valid")
    private String email;

    @NotNull
    @Size(min = 10, max = 10, message = "phone should have only 10 numbers")
    @Pattern(regexp="(^$|[0-9]{10})", message = "phone should have number character only")
    private String phone;

}
