<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: qwer1
  Date: 2024-06-24
  Time: 오후 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request response는 내장 객체이다.
    // jsp는 서블릿으로 변경된다. => 제스퍼
    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt( request.getParameter("age"));

    System.out.println("usernane = " + username + "age = " + age);

    Member member = new Member(username,age);
    memberRepository.save(member);


%>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>
