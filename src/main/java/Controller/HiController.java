package Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

    @RestController
    public class HiController {

        @RequestMapping("/")
        public String index() {
            return "aver si anda esta vergaaaaaaaa";
        }

    }

