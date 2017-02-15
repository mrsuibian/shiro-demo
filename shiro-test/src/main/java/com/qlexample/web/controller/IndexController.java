package com.qlexample.web.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlexample.entity.SysResource;
import com.qlexample.entity.SysUser;
import com.qlexample.service.ResourceService;
import com.qlexample.service.UserService;
import com.qlexample.web.bind.annotation.CurrentUser;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index(@CurrentUser SysUser loginUser,Model model){
		Set<String> permissions = userService.findPermissionByUserName(loginUser.getUsername());
        List<SysResource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
	}
    
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req,Model model){
		 String exceptionClassName = (String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	        String error = null;
	        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
	            error = "用户名/密码错误";
	        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
	            error = "用户名/密码错误";
	        } else if(exceptionClassName != null) {
	            error = "其他错误：" + exceptionClassName;
	        }
	        model.addAttribute("error", error);
		return "login";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome(){
		return "welcome";
	}
}
