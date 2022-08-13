package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메서드 실행이 끝났을 때마다 호출을 함
    public void afterEach() {
        repository.clearStore(); // 전체 테스트를 할 경우 하나의 메소드 테스트가 끝나면 호출이 되어 store를 비워주고 에러를 방지함
    }                            // 테스트는 순서와 관계없이, 의존관계 없이 설계가 되어야한다.

    @Test
    public void save() { //sava 기능 테스트
        Member member = new Member();
        member.setName("spring"); // memver 인스턴스에 이름 넣기

        repository.save(member); // 이름 저장

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result); //member랑 result랑 같은지
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void finfAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2); // 전체를 가져와서 반환하는데 size는 여기 담겨져있는 객체의 갯수
    }
}
