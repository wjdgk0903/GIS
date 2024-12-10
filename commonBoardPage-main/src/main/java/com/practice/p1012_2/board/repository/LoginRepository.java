package com.practice.p1012_2.board.repository;



import com.practice.p1012_2.board.entity.Member;

import java.util.List;

public interface LoginRepository {

    List<Member> findById(String id);

    List<Member> findBPwd(String pwd);

}
