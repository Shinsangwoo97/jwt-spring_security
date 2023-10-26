package com.example.jwtspring_security.user.model.entity;

import com.example.jwtspring_security.user.model.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter
@SQLDelete(sql = "UPDATED user SET deleted_at = NOW() where id=?") //delete 메소드 호출시 삭제대신 이 쿼리를 사용
@Where(clause = "deleted_at is NULL")
public class UserEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Column(name = "register_at")
    private Timestamp registerAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt(){
        this.registerAt = Timestamp.from(Instant.now());
    }
    @PreUpdate
    void updatedAt(){
        this.updatedAt = Timestamp.from(Instant.now());
    }
    public static UserEntitiy of(String userName, String password) {
        UserEntitiy userEntitiy = new UserEntitiy();
        userEntitiy.setUserName(userName);
        userEntitiy.setPassword(password);
        return userEntitiy;
    }
}
