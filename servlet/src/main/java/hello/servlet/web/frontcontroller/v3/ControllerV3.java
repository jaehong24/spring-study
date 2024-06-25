package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String,String> paramMap);

}
