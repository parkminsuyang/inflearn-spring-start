// 회원 컨트롤러에 의존관계 추가
//hello/helllo_spring/controller/MemberController

package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

	private final MemberService memberService;
    
    @Autowired // 스프링과 연결된 객체를 스프링 컨테이너에서 찾아서 넣어줌(DI, 의존성 주입)
 		public MemberController(MemberService memberService) {
 			this.memberService = memberService;
    }
 }
