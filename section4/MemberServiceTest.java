// hello/hello_spring/service/MemberServiceTest
package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import static org.assertj.core.api.Assertions.assertThat;

import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // @Test 메서드 실행 전 호출
    public void beforeEach(){
    	// 새로운 객체 생성
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }
    
    @Test
    void 회원가입() {
        //given
        Member member=new Member();
        member.setName("hello");

        //when
        Long saveId=memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1=new Member();
        member1.setName("spring");


        Member member2=new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); // 실제로 예외 발생하는지 확인
        
        /*
        try{
            memberService.join(member2);
            fail("에러가 발생해야 합니다");
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.12345");
        }
*/
        memberService.join(member2);

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
