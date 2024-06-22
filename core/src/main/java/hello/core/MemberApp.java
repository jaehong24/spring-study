package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.order.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();;

//      AppConfig의 설정 정보를 통해 Bean으로 등록 된다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

//      Bean으로 등록 된 memberService 메서드 이름을 꺼낸다. 타입으로도 꺼낸다.
        MemberService memberService =  applicationContext.getBean("memberService", MemberService.class);

//        MemberService service = new MemberServiceImp();
        Member member = new Member(1L,"memberA", Grade.BASIC);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
