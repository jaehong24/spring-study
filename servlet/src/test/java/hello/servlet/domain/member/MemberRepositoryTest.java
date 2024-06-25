package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    // 싱글톤 사용
    MemberRepository repository = MemberRepository.getInstance();

    @AfterEach
    void getEeach(){

        repository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);

//        when
        Member saveMember = repository.save(member);

        // then
        Member findMember =repository.findById(member.getId());

        Assertions.assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll(){
//    given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        repository.save(member1);
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);



    }

}
