package ru.icmit.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.icmit.logistics.domain.User;
import ru.icmit.logistics.service.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request, @ModelAttribute("model") ModelMap model) {

        String app_path = request.getContextPath();
        model.addAttribute("app_path", app_path);

        return "/login";
    }

    @PostMapping("/usercheckform")
    public String userCheckForm(HttpServletRequest request,
                                @RequestParam(name = "username") String username,
                                @RequestParam(name = "password") String password,
                                @ModelAttribute("model") ModelMap model) {

        String path = request.getContextPath();
        model.addAttribute("app_path", path);

        HttpSession session = request.getSession(false);
        if (session != null) {
                return "/index";
        }

        //Session is null, try login
        User user = userDao.findByUsername(username);
        String salt = user != null ? user.getSalt() : "";

        try {
            request.login(username, password + salt);
            return "/index";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/login";
    }
}
