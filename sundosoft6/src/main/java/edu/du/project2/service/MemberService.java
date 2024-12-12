package edu.du.project2.service;


import edu.du.project2.dto.MemberRequest;
import edu.du.project2.entity.Member;
import edu.du.project2.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminAccount() {
                Member admin = new Member();
                admin.setEmail("admin@admin.com");  // 관리자 이메일
                admin.setPassword(passwordEncoder.encode("admin123"));  // 관리자 비밀번호 (암호화)
                admin.setName("관리자");  // 관리자 이름
                admin.setTel("000-0000-0000");
                admin.setRole("ADMIN");  // 관리자 역할

                // 관리자 정보를 저장
                memberRepository.save(admin);
    }


    public String registerMember(MemberRequest request) {
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            return "이미 존재하는 이메일입니다.";
        }
        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setPassword(passwordEncoder.encode(request.getPassword())); // 비밀번호 암호화
        member.setName(request.getName());
        member.setTel(request.getTel());
        member.setAddress(request.getAddress());
        member.setDetailAddress(request.getDetailAddress());
        member.setRole("USER");

        memberRepository.save(member);
        return "회원가입 성공";
    }

    public boolean loginMember(MemberRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail()).orElse(null);
        if (member != null && passwordEncoder.matches(request.getPassword(), member.getPassword())){ // 비밀번호 암호화 필요
            return true;
        }
        return false;
    }



}
