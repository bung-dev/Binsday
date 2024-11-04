package com.example.binsday.user.dto.response;

import com.example.binsday.user.entity.UserEntity;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserReadResponse {

    private String userId;

    private String userName;

    private String userTel;

    private String userEmail;

    //entity -> dto
    public UserReadResponse(UserEntity user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userTel = user.getUserTel();
        this.userEmail = user.getUserEmail();
    }

}
