package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장 된 회원을 반환
    Optional<Member> findById(Long id); //아이디로 회원 찾기
    Optional<Member> findByName(String name); //이름으로 회원 찾기
    List<Member> findAll(); //모든 회원 리스트 반환
}

