package ru.icmit.logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String app_path = request.getContextPath();
        model.addAttribute("app_path", app_path);

        return "/index";
    }
}
