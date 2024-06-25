package hello.servlet.basic.reuest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("전체 파라미터 조회 - start");
        req.getParameterNames().asIterator().
                forEachRemaining(parmeter -> System.out.println(parmeter +"=" +req.getParameter(parmeter)));
        System.out.println("전체 파라미터 조회 - end");
        System.out.println();

        System.out.println("단일 파라미터 제공");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();


    }
}
