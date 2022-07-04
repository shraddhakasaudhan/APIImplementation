package com.springbootwebservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootwebservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
