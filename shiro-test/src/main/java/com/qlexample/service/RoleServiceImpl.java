package com.qlexample.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlexample.entity.SysRole;
import com.qlexample.repository.SysRoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
    
	@Autowired
	private SysRoleRepository roleRepository;
	
	@Autowired
	private ResourceService resourceService;
	
	@Override
	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            SysRole role = roleRepository.findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
	}

	@Override
	public Set<String> findPermissions(Long[] roleIds) {
		Set<Long> resourceIds = new HashSet<Long>();
		for (Long roleId : roleIds) {
			SysRole role = roleRepository.findOne(roleId);
			String [] resourceLists = role.getResourceIds().split(",");
			for(int i = 0;i<resourceLists.length;i++){
				resourceIds.add(Long.valueOf(resourceLists[i]));
			}
		}
		return resourceService.findPermissions(resourceIds);
	}

}
