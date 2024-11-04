package com.example.binsday.user.repository;

import com.example.binsday.user.dto.response.UserReadResponse;
import com.example.binsday.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
