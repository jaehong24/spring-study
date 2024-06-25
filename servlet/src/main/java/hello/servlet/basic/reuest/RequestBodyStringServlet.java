package hello.servlet.basic.reuest;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/request-body-string")
public class RequestBodyStringServlet  extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      메세지 바디의 내용을 바이트로 얻을 수 있다.
//      그 후 스프링 유틸을 이용해서 정보를 String으로 변환한다.
        ServletInputStream inputStream = request.getInputStream();
        String mewssagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("message body = " + mewssagebody);
        response.getWriter().write("ok");

    }
}
