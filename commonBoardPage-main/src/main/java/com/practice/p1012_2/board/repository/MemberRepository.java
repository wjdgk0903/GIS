package com.practice.p1012_2.board.repository;

import com.practice.p1012_2.board.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
        em.flush();
    }

    public List<Member> findById(String loginId){
        String jpql = "select m from Member m where m.loginId=:loginId";
        List<Member> findId = em.createQuery(jpql, Member.class).setParameter("loginId", loginId).getResultList();
        return findId;
    }
}
