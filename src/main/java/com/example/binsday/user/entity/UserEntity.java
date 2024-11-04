package com.example.binsday.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "USER_KEY")
    private Long userKey; //회원 고유 번호

    @Column(unique = true, nullable = false, name = "USER_ID")
    private String userId; //아이디

    @Column(nullable = false, name = "USER_PWD")
    private String userPwd; //비밀번호

    @Column(nullable = false, name = "USER_NAME")
    private String userName; //이름

    @Column(nullable = false, name = "USER_TEL")
    private String userTel; //전화번호

    @Column(nullable = false, name = "USER_EMAIL")
    private String userEmail; //이메일

    @CreatedDate
    private LocalDateTime createAt; //생성 날짜

    private LocalDateTime deleteAt; //삭제 날짜


    //setter
    public void changeUserId(String userId) {
        this.userId = userId;
    }

    public void changeUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void changeUserName(String userName) {
        this.userName = userName;
    }

    public void changeUserTel(String userTel) {
        this.userTel = userTel;
    }

    public void changeUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
