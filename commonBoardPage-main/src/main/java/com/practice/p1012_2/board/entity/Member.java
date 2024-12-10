package com.practice.p1012_2.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String username;

    private String password1;
    private String password2;
    private String email;

    private String brithDay;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Embedded
    private Address address;


    @Builder
    public Member(String loginId, String username, String password1, String password2, String email, String brithDay, Role role, Address address) {
        this.loginId = loginId;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
        this.brithDay = brithDay;
        this.role = role;
        this.address = address;
    }




}

