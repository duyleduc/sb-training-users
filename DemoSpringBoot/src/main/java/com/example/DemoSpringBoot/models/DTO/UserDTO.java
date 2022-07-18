package com.example.DemoSpringBoot.models.DTO;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

public class UserDTO {
    private BigInteger id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date createdDate;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String email, String phone, Date createdDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public UserDTO(String firstName, String lastName, String email, String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdDate = new Date();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

}
