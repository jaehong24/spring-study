package hello.core.beanfind;

import hello.core.discount.DisCountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameConfig.class);
//
//    @Test
//    @DisplayName("타입이 두개 이상이면 ")
//    NoUniqueBeanDefinitionException
//    void findBeanByTypeDuplicate(){
//      MemberRepository memberRepository =  ac.getBean(MemberRepository.class);
//    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈이름을 지정하면 된다. ")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository>  beansOfType  =  ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + " value = " +beansOfType.get(key));
        }
        System.out.println("beanOfType=" + beansOfType);

    }

    @Configuration
    static class SameConfig {

        @Bean
        public MemberRepository memberRepository1() {

            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {

            return new MemoryMemberRepository();
        }
    }
}
