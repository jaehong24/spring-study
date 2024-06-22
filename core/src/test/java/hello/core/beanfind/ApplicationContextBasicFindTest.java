package hello.core.beanfind;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberservice = "  +memberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImp.class);

    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberservice = "  +memberService);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImp.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImp.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImp.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX(){
      MemberService xxxx =   ac.getBean("xxxx",MemberService.class);


    }


}
