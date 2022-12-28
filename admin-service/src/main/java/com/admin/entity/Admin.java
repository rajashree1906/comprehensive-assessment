package com.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
	
	@Id
	@Column(unique=true)
    @NotNull(message="user name cannot be blank")
	private String username;
	
    @NotNull(message="password cannot be blank")
	private String password;
    
    
    @NotNull(message="admin name cannot be blank")
	private String adminName;
    
    
	
	

	
	
	

}
