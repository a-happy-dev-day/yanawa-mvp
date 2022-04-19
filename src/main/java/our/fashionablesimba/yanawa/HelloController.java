package our.fashionablesimba.yanawa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("hello")
    public List<String> hello() {
        log.info("{}", "event start");
        return Arrays.asList("Have a good day");
    }
}
