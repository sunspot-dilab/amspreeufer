package com.vw.dilab.amspreeufer.library;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/")
    public String showDashboard() {
        return "index";
    }
}
