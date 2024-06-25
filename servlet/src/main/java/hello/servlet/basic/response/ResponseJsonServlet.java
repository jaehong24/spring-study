package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //content-type: application/json
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(25);

//        {"username":"kim , "age":25}
        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);

    }
}
