package hello.core;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){

        return new MemberServiceImp(memberRepository());
    }
    @Bean
    public  MemoryMemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){

        return new OrderServiceImp(memberRepository(), disCountPolicy());

    }
    @Bean
   public DisCountPolicy disCountPolicy(){

        return  new RateDiscountPolicy();
   }
}
