package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void  statefulServiceSingleton(){
       ApplicationContext ac =  new AnnotationConfigApplicationContext(TestConfig.class);
       StatefulService statefulService1 =  ac.getBean(StatefulService.class);
        StatefulService statefulService2 =  ac.getBean(StatefulService.class);

        //Tharead A 사용자 10000원 주문
       int userAprice =  statefulService1.order("userA",10000);

        //Tharead B 사용자 20000원 주문
        int userBprice = statefulService1.order("userA",20000);


        int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);
        System.out.println("price = " + userBprice);

    }

    static class  TestConfig{
        @Bean
        public StatefulService statefulService(){

            return new StatefulService();
        }
    }

}