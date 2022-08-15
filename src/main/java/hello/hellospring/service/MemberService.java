package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 스프링 컨테이너에 등록
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원x
        vaildateDuplicateMember(member); // 아래 메소드로 생성함
        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        // ifPresent Optional 객체가 값을 가지고 있으면 실행
        // findByName은 jpa에서 기본으로 제공하는 Optional 타입 메소드
    }
    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    // Id 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
