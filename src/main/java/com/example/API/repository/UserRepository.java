package com.example.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
