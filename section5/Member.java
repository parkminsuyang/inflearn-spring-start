// 회원 서비스 스프링 빈 등록
// hello/hello_spring/domain/Member

@Service //memberService가 스프링 컨테이너에 등록됨
public class MemberService {
    private final MemberRepository memberRepository;

	@AutoWired // MemberRepository 타입의 스프링 빈을 찾아 memberService에 주입(DI)
    // 생성자가 1개만 있을 경우 @Autowired 생략 가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
