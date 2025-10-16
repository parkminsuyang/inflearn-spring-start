// 회원 리포지토리 메모리 구현체 테스트
// src/test/java/hello/hello_spring/repository/MemoryMemberRepositoryTest

package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
	// 테스트 대상 긱체 생성
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach //@Test 메서드 끝날 때마다 호출
    public void afterEach(){
        repository.clearStore(); // 메모리 DB에 저장된 데이터 삭제
    }
    @Test
    public void save(){
    	//given
        Member member=new Member();
        member.setName("spring");
		
        //when
        repository.save(member);

		//then
        //ID로 멤버 찾기
        Member result=repository.findById(member.getId()).get();
        //찾은 멤버와 저장한 멤버가 같은지 검증
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
    	//given
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);
		
        
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);
        
		//when
        Member result=repository.findByName("spring1").get();
        
        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
    	//given
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);
		
        //when
        List<Member> result=repository.findAll();
		
        //then
        assertThat(result.size()).isEqualTo(2);
    }



}
