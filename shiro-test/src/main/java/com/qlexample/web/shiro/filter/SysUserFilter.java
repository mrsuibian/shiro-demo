package com.qlexample.web.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.qlexample.Constants;
import com.qlexample.service.UserService;

public class SysUserFilter extends PathMatchingFilter {
     
	@Autowired
	private UserService userService;
	
	 @Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(Constants.CURRENT_USER, userService.findByUserName(username));
		return true;
//		return super.onPreHandle(request, response, mappedValue);
	}
}
