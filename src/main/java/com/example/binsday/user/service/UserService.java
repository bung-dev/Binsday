package com.example.binsday.user.service;

import com.example.binsday.user.dto.response.UserReadResponse;
import com.example.binsday.user.entity.UserEntity;
import com.example.binsday.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;


    //멤버 상세 조회 (1개)
    public UserReadResponse read(Long userKey){
        UserEntity user = userRepository.findById(userKey).orElseThrow(IllegalArgumentException::new);
        return new UserReadResponse(user);
    }

    //멤버 전체 조회
    @Transactional(readOnly = true)
    public List<UserReadResponse> readList(){
        return userRepository.findAll().stream()
                .map(UserReadResponse::new)
                .collect(Collectors.toList());
    }
}
