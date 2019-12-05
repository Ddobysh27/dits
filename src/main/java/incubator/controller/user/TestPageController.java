package incubator.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {

    private static int counter = 0;

    @GetMapping(value = "/nextTestPage1")
    public String nextTestPage1() {
        if (counter < 3) {
            counter++;
            return "User/testPage";
        } else
            return "User/resultPage";
    }

}
