package com.practice.p1012_2.board.controller;

import com.practice.p1012_2.board.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

        @GetMapping("/user")
        public String user() {
            return "user/userLogin"; // userLogin.html 파일을 가리킵니다.
        }

    @GetMapping("/userLoginForm")
    public String showLoginForm() {
        return "user/loginForm"; // loginForm.html을 반환
    }

    @PostMapping("/userLoginForm") // 회원가입 폼 데이터 처리
    public String handleSignup(@ModelAttribute MemberDto memberDto) {
        // 회원가입 처리 로직 추가
        System.out.println("회원 정보: " + memberDto);

        // 성공 시 로그인 페이지로 리다이렉트
        return "redirect:/user";
    }
    }


