package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImp;

public class OrderApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImp();
        OrderService orderService = new OrderServiceImp();

        Long memberId = 1L;
        Member member  = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId,"itemA",10000);


        System.out.println("order = "+ itemA.toString());
        System.out.println("orderPrice = "+ itemA.calculatePrice());

    }
}
