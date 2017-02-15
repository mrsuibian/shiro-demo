package com.qlexample.service;

import java.util.Set;

import com.qlexample.entity.SysRole;
import com.qlexample.entity.SysUser;

public interface UserService {
    
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public SysUser findByUserName(String username);
	
	public Set<String> findRoleByUserName(String username);
	
	public Set<String> findPermissionByUserName(String username);
}
