package com.example.binsday.user.repository;


import com.example.binsday.user.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 생성 테스트")
    void create(){
        //GIVEN
        UserEntity user = UserEntity.builder()
                .userId("testid")
                .userPwd("1234")
                .userEmail("test@naver.com")
                .userTel("010-1111-2222")
                .userName("테스트")
                .build();
        //WHEN
        UserEntity userSave = userRepository.save(user);

        //THEN
        assertNotNull(userSave);
        assertEquals(userSave.getUserId(),user.getUserId());
    }

    @Test
    @DisplayName("유저 조회 테스트")
    void read(){
        //GiVEN
        UserEntity user = UserEntity.builder()
                .userId("testid")
                .userPwd("1234")
                .userEmail("test@naver.com")
                .userTel("010-1111-2222")
                .userName("테스트")
                .build();
        userRepository.save(user);
        //WHEN
        UserEntity userEntity = userRepository.findById(user.getUserKey()).orElseThrow(IllegalArgumentException::new);
        //THEN
        assertNotNull(userEntity);
        assertEquals(user.getUserId(),userEntity.getUserId());
    }

    @Test
    @DisplayName("유저 전체 조회")
    void readList(){
        IntStream.rangeClosed(1, 20).forEach(i -> {
            //GIVEN
            UserEntity user = UserEntity.builder()
                    .userId("testid"+i)
                    .userPwd("1234")
                    .userEmail("test@naver.com")
                    .userTel("010-1111-2222")
                    .userName("테스트"+i)
                    .build();
            userRepository.save(user);
        });
        //WHEN
        List<UserEntity> all = userRepository.findAll();
        //THEN
        for (UserEntity user : all) {
            System.out.println(user);
        }
    }

    @Test
    @DisplayName("유저 정보 수정")
    void update(){
        //GiVEN
        UserEntity user = UserEntity.builder()
                .userId("testid")
                .userPwd("1234")
                .userEmail("test@naver.com")
                .userTel("010-1111-2222")
                .userName("테스트")
                .build();
        userRepository.save(user);
        //WHEN
        UserEntity userEntity = userRepository.findById(user.getUserKey()).orElseThrow(IllegalArgumentException::new);
        userEntity.changeUserId("테스트id");
        //THEN
        assertNotNull(userEntity);
        assertEquals("테스트id",userEntity.getUserId());
        assertNotEquals(user.getUserId(),userEntity.getUserId());
    }
}