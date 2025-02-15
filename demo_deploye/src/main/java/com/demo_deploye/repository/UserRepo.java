package com.demo_deploye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo_deploye.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
