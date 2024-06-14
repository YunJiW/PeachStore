package com.ll.peach.boundedContext.home;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

//    @PreAuthorize("isAnonymous()")
//    @GetMapping
//    public String home() {
//        return "index.html";
//    }
}
