package learn.sfg.sfgpc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @GetMapping({"", "/", "index", "index.html"})
    public String listOfOwners() {
        return "owners/index";
    }
}
