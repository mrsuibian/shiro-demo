package com.qlexample.dao.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qlexample.dao.UserDao;
import com.qlexample.entity.SysUser;
import com.qlexample.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {
    
	
	@Resource
	private UserRepository userRepository;
	
	@Override
	public SysUser findByName(String name) {
		return null;
	}

	@Override
	public SysUser save(SysUser user) {
		return userRepository.save(user);
	}

}
