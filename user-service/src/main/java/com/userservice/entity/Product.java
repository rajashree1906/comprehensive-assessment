package com.userservice.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@NotNull(message="id cannot be blank")
	private Long id;
	
	@NotNull(message=" name cannot be blank")
	private String name;
	
	@NotNull(message="price cannot be blank")
	private Double price;
	
	
}
