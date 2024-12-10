package com.practice.p1012_2.board.repository;


import com.practice.p1012_2.board.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {

    private final EntityManager em;


    @Override
    public List<Member> findById(String id) {
        String jpql = "SELECT m FROM Member m WHERE m.loginId = :loginId";
        List<Member> loginId = em.createQuery(jpql, Member.class).setParameter("loginId", id).getResultList();
        return loginId;
    }

    @Override
    public List<Member> findBPwd(String pwd) {
        String jpql = "SELECT m FROM Member m WHERE m.password1 = :password";
        List<Member> password = em.createQuery(jpql, Member.class).setParameter("password", pwd).getResultList();
        return password;
    }

}
