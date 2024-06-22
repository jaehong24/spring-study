package hello.core.member;

public class MemberServiceImp implements    MemberService{

//    인터페이스만 있으니, 추상화에만 의존하고 있는 것이다.

    private final MemberRepository memberRepository;

    public MemberServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
