// 회원 리포지토리 메모리 구현체
// hello/hello_spring/repository/MemoryMemberRepository
// 동시성 문제 고려되어 있지 않음 (여러 사용자가 store나 sequence에 접근하며 오류 발생 가능성)

package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;


public class MemoryMemberRepository implements MemberRepository {
	
    //모든 회원 객체 저장
    //Key(Long)-Value(Member)
    //static: 클래스가 여러 번 생성되어도 데이터 저장소 하나 유지
    private static Map<Long, Member> store = new HashMap<>();
    // 새로운 회원 저장시 ID 자동으로 부여
    private static long sequence=0L;
    
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //새로운 회원의 ID
        store.put(member.getId(), member); //새로운 ID, 회원을 Map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
    	
        //null일 경우 대비 Optional.ofNullable()
        return Optional.ofNullable(store.get(id)); 
        
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //모든 회원 목록 strean으로 
        		//이름 일치하는 회원 찾기
                .filter(member -> member.getName().equals(name))
                // 가장 먼저 나오는 회원 Optional로 감싸 반환
                .findAny();

    }

    @Override
    public List<Member> findAll() {
    
    	//Map에 있는 모든 회원 객체 ArrayList에 담아 반환
        return new ArrayList<>(store.values()); 
    }

    public void clearStore(){
        store.clear();
    }

}
