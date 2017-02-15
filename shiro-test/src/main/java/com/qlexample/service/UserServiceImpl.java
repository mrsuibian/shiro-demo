package com.qlexample.service;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlexample.entity.SysUser;
import com.qlexample.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public SysUser findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public Set<String> findRoleByUserName(String username) {
		SysUser user = findByUserName(username);
		if(user == null){
			return Collections.EMPTY_SET;
		}
		String [] lists = user.getRoleIds().split(",");
		Long [] ids = new Long[lists.length];
		for(int i = 0;i<lists.length;i++){
			ids[i] = Long.valueOf(lists[i]);
		}
		return roleService.findRoles(ids);
	}

	@Override
	public Set<String> findPermissionByUserName(String username) {
		SysUser user = findByUserName(username);
		if (user == null) {
			return Collections.EMPTY_SET;
		}
		String [] lists = user.getRoleIds().split(",");
		Long [] ids = new Long[lists.length];
		for(int i = 0;i<lists.length;i++){
			ids[i] = Long.valueOf(lists[i]);
		}
		return roleService.findPermissions(ids);
	}

}
