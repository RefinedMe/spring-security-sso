package com.refined.sso.controller;

import java.security.Principal;

import com.refined.sso.entity.UserInfo;
import com.refined.sso.service.BaseMaccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private BaseMaccountService baseMaccountService;
    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
    @RequestMapping("/user/info")
    public UserInfo info(Principal principal) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        System.out.println(principal);
        return baseMaccountService.findUserInfo(principal.getName());
    }
}
