package hello.servlet.basic.reuest;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

//    스프링은 잭슨을 기본 json 라이브러리로 사용
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletInputStream inputStream = request.getInputStream();
        String messagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("message body = "  + messagebody);

        HelloData helloData = objectMapper.readValue(messagebody, HelloData.class);
        System.out.println("hellodata name = " + helloData.getUsername());
        System.out.println("hellodata age = " + helloData.getAge());

    }
}
