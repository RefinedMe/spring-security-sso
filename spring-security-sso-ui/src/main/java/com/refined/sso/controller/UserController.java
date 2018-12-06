package com.refined.sso.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.refined.sso.entity.BaseMaccount;
import com.refined.sso.service.BaseMaccountService;
import com.refined.sso.util.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserController {
    private BaseMaccountService baseMaccountService;

    @RequestMapping("/user/info")
    public R user(Principal principal) throws Exception {
        System.out.println(principal);
        BaseMaccount baseMaccount = baseMaccountService.findUserInfo(principal.getName());
        String a = SecurityUtil.encrypt(baseMaccount.getMaAid());
        return R.ok(a);
    }

    @RequestMapping("/user/login")
    public void info(HttpServletRequest request, HttpServletResponse response, Principal principal) throws Exception {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
//        request.getSession().setAttribute("user",authentication);
//        JSONObject json = restTemplate.getForEntity("http://localhost:8082/ui/user/info", JSONObject.class).getBody();
        BaseMaccount baseMaccount = baseMaccountService.findUserInfo(principal.getName());
        String aid = SecurityUtil.encrypt(baseMaccount.getMaAid());
        try {
//            response.sendRedirect("http://10.125.4.32:8070/birmy/#/loginRedirect?aid=" + aid);
            response.sendRedirect("http://www.xiaoniuzp.com/birmy/#/loginRedirect?aid=" + aid);
//            response.sendRedirect("http://localhost:3000/#/loginRedirect?aid=" + aid);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(principal);
//        return authentication;
    }
}
