package com.example.binsday.user.dto.request;

import com.example.binsday.user.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequest {
    @NotBlank
    private String userId; //아이디

    @NotBlank
    private String userPwd; //비밀번호

    @NotBlank
    private String userName; //이름

    @NotBlank
    private String userTel; //전화번호

    @NotBlank
    private String userEmail; //이메일

    public UserRequest(UserEntity user) {
    }

    //dto -> entity
    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .userPwd(userPwd)
                .userTel(userTel)
                .userName(userName)
                .userEmail(userEmail)
                .build();
    }
}
