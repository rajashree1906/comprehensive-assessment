package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.admin.entity.Admin;


@EnableJpaRepositories

@Repository
public interface AdminRepository extends JpaRepository<Admin,String>{

    public Admin findByUsername(String username);
    public Admin findByUsernameAndPassword(String username,String password);

}
