package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;

public class MemberApp {
    public static void main(String[] args) {

        MemberService service = new MemberServiceImp();
        Member member = new Member(1L,"memberA", Grade.BASIC);

        service.join(member);

        Member findMember = service.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
