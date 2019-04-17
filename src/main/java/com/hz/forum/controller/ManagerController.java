package com.hz.forum.controller;

import com.hz.forum.entity.Manager;
import com.hz.forum.service.ManagerService;
import com.hz.forum.utils.CreateValidateCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
@Controller
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    /*@RequestMapping("/loginIn")
    public String loginIn(HttpSession session,String forumName,String forumPassword){
        if (ms.findByName(forumName) != null){
            Manager manager = ms.find(forumName, forumPassword);
            *//*System.out.println(manager);*//*
            if (manager != null){
                session.setAttribute("username",manager.getForumName());
                return "redirect:/main/main.html";
            }
        }
            return "redirect:/login.html";
    }*/

    @RequestMapping("/login")
    public String login(String forumName,String forumPassword,
                        HttpSession session,HttpServletResponse response)
            throws UnsupportedEncodingException {
        {
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(forumName,
                        forumPassword));
                Cookie userCookie=new Cookie("checkName",
                        URLEncoder.encode(forumName,"UTF-8"));
                userCookie.setMaxAge(30*24*60*60);
                userCookie.setPath("/");
                response.addCookie(userCookie);
                session.setAttribute("user",forumName);
                return "redirect:/main/main.html";

            }catch (UnknownAccountException e1){
                e1.printStackTrace();
                return "redirect:/login.html";
            } catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                return "redirect:/login.html";
            }catch (AuthenticationException  e){
                e.printStackTrace();
                return "redirect:/login.html";
            }
        }
    }


    @RequestMapping("/getVcode")
    public void create(HttpSession session,HttpServletResponse response) throws Exception{

        CreateValidateCode vCode = new CreateValidateCode(100,30,1,10);

        session.setAttribute("code", vCode.getCode());

        vCode.write(response.getOutputStream());
    }


    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String,String> checkUserName(String managerName){
        //创建一个map，用来封装数据
        System.out.println(managerName);
        Map<String,String> managerMap = new HashMap<String,String>();
        String flag="用户不存在";
        Manager ma =ms.findByName(managerName);
        System.out.println(ma);
        if (ma!=null) {
            flag="用户已存在";
        }
        managerMap.put("manager",flag);
        //测试输出
        System.out.println("打印这句话说明,Ajax Asynchronous request 发送成功...");
        return managerMap;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modifyPassword(HttpSession session,
                                 String forumPassword,String forumNewPassword,
                                 String onceForumNewPassword){
        System.out.println("===============");

        Object username = session.getAttribute("username");
        Manager manager = ms.findByName(username.toString());
        String pwd = DigestUtils.md5Hex(forumPassword+manager.getForumSalt());
        if (pwd.equals(manager.getForumPassword())){
            if (forumNewPassword.equals(onceForumNewPassword)){
                String newPwd = DigestUtils.md5Hex(forumNewPassword+
                        manager.getForumSalt());
                manager.setForumPassword(newPwd);
                int modify = ms.modify(manager);
                if (modify != 0){
                    return "success";
                }
            }
        }
        return "fail";
    }


    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.setAttribute("username",null);
        return "success";
    }

    @RequestMapping("/logOut")
    public String logOut(){
        System.out.println("123456");
        return "redirect:/login.html";
    }

    @RequestMapping("/getName")
    @ResponseBody
    public String getName(HttpSession session){
        Object username = session.getAttribute("username");
        System.out.println(username);
        return username.toString();
    }
}
