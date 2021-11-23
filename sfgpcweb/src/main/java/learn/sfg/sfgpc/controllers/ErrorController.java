package learn.sfg.sfgpc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/oups")
    public String notImplemented() {
        return "notimplemented";
    }
}
