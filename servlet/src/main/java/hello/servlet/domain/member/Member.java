package hello.servlet.domain.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Member {
private  Long  id;
private  String username;
private int age;


    public Member(String usename, int age) {

        this.username=usename;
        this.age=age;

    }
}
