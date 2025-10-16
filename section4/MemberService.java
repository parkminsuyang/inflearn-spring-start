// 회원 서비스
// hello/hello_spring/service/MemberService
package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
public class MemberService {
    // MemberService가 MemoryMemberRepository를 직접 생성하여 사용
    // DB 변경시 수정
    // 서비스와 리포지토리가 강하게 묶여 테스트하기 어려움
    private final MemberRepository memberRepository = new MemoryMemberRepository();
}
*/

public class MemberService {
    private final MemberRepository memberRepository;

	// 생성자를 통해 외부에서 MemberRepository 객체를 받음(DI, 의존성 주입)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
    *전체 회원 조회
     **/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
