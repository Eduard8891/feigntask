package sharipov.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import sharipov.service.MainServiceClass;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    MainServiceClass mainServiceClass;

    @GetMapping ("/")
    public String getRates() {
        return mainServiceClass.getRates();
    }

}
