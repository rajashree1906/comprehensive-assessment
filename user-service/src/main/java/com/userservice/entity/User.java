package com.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(unique=true)
    @NotNull(message="user name cannot be blank")
    private String username;
    
    @NotNull(message="first name cannot be blank")
    private String firstName;
    
    @NotNull(message="last name cannot be blank")
    private String lastName;
    
    @Column(unique=true)
    @Email(message="email id cannot be blank")
    private String emailId;
    
    @NotNull(message="address cannot be blank")
    private String address;
    
    @NotNull(message="contact number cannot be blank")
    private String contactNumber;
    
    @NotNull(message="password cannot be blank")
    private String password;
    
    
	}