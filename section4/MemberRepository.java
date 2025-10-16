//회원 리포지토리 인터페이스
//hello/hello_spring/repository/MemberRepository

package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //새로운 회원 객체 저장 
    Optional<Member> findById(Long id); //ID로 회원 찾기
    Optional<Member> findByName(String name); //이름으로 회원 찾기
    List<Member> findAll(); //모든 회원 목록 조회

}
