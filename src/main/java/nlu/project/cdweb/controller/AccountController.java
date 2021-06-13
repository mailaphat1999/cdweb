package nlu.project.cdweb.controller;


import nlu.project.cdweb.custom.Config;
import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.custom.Security;
import nlu.project.cdweb.entity.Price;
import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.mail.SendEmail;
import nlu.project.cdweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;


@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = Security.hashMD5(request.getParameter("password"));
        String locate = request.getParameter("locate");
        if(userService.login(username,password)!=null){
            User user = userService.login(username,password);
            session.setAttribute("user",user);
        }
        response.sendRedirect(locate);
    }
    @RequestMapping(value = "/logout")
    public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        session.setAttribute("user",null);
        System.out.println(request.getParameter("locate"));
        response.sendRedirect(request.getParameter("locate").replace('-','&'));
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(HttpServletRequest request,HttpServletResponse response) throws MessagingException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = Security.hashMD5(request.getParameter("password"));
        String confirm = Security.hashMD5(request.getParameter("confirm"));
        String locate = request.getParameter("locate");
        if(password.equals(confirm)){
            User user = new User();
            user.setEmail(email);user.setPassword(password);user.setActive("0");user.setAddress("");
            user.setUsername(username);user.setName(username);user.setDateCreate(MyDateFormat.getNow());
            user.setGender("");user.setImage("/images/user/1.gif");user.setPermission("1");
            user.setPhone("");
            userService.save(user);

            String subject = "Active account Elite Shoppy";
            String message = "Click to link to confirm: " + Config.HOST+"verify/activeUser?email=" + email;
            SendEmail.sendEmail(email,subject,message);
        }
        response.sendRedirect(locate);
    }
    @RequestMapping(value = "/verify/activeUser")
    public void verify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        userService.active(email);
        response.sendRedirect("home");
    }
}