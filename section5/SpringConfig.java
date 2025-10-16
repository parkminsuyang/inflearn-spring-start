// hello/hello_spring/service/SpringConfig

package hello.hello_spring.service;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스가 스프링 설정(Configuration)을 담당함을 알림
public class SpringConfig {

    @Bean // MemberService(메서드가 반환하는 객체) 스프링 빈 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean // MemberRepository 스프링 빈 등록
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
