package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.UserService;
import com.cafe24.security.Auth;
import com.cafe24.security.Auth.Role;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping( "/user" )
@SessionAttributes("authUser")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping( value = "/join", method = RequestMethod.GET )
    public String join( @ModelAttribute User user ) {
	return "user/join";
    }

    @RequestMapping( value = "/join", method = RequestMethod.POST )
    public String joinPost( @ModelAttribute User user ) {
	userService.joinUser( user );
	return "redirect:/user/joinsuccess";
    }

    @RequestMapping( "/joinsuccess" )
    public String joinsuccess() {
	return "user/joinsuccess";
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login() {
	return "user/login";
    }

    @Auth(role=Role.USER)
    @RequestMapping( value = "/modify", method = RequestMethod.GET )
    public String modify(@AuthUser User authUser, Model model) {
	User user = userService.getUser( authUser.getNo() );
	model.addAttribute( "user", user);
	return "user/modify";
    }
    
    @Auth(role=Role.USER)
    @RequestMapping( value = "/modify", method = RequestMethod.POST )
    public String modifyPost(@ModelAttribute User user, Model model) {
	User modifiedUser = userService.modifyUser( user );
	model.addAttribute("authUser", modifiedUser);
	return "redirect:/";
    }
    
    

}
