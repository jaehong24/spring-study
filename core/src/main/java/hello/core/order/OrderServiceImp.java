package hello.core.order;

import hello.core.discount.DisCountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImp implements  OrderService{

    private final MemberRepository memberRepository;
    private  final DisCountPolicy disCountPolicy;

    //  private final DisCountPolicy disCountPolicy = new FixDiscountPolicy(); 추상에도 의존하고, 구체 적인것에 의존한다.


    public OrderServiceImp(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice =  disCountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
