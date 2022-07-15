package com.example.springrestapi.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.springrestapi.entities.User;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Last name is required")
    @Size(max = 64, message = "Last name max length is 64 character")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Size(max = 64, message = "Email max length is 64 character")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]*$", message = "Phone number only contain number")
    @Size(min = 10, max = 10, message = "Phone number is 10 character")
    private String phone;

    @NotBlank(message = "First name is required")
    @Size(max = 8, message = "First name max length is 8 character")
    private String firstName;

    public User toUser() {
        return new User(this.lastName, this.email, this.phone, this.firstName);
    }

}
