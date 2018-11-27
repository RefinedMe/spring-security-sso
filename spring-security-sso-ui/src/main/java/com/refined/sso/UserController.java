package com.refined.sso;


import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserController {

    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
    @RequestMapping("/user/info")
    public Authentication info(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
//        System.out.println(principal);
        try {
            response.sendRedirect("http://10.125.4.32:8070/birmy/#/home/dashboard");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authentication;
    }
}
