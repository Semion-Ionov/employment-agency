package omgtu.employment_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Default {
    @GetMapping("/")
    public String redirect() {
        return "redirect:/activities";
    }
}
