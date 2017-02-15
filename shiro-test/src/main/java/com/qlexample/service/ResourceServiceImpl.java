package com.qlexample.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qlexample.entity.SysResource;
import com.qlexample.repository.SysResourceRepository;

@Service
public class ResourceServiceImpl implements ResourceService {
    
	@Autowired
	private SysResourceRepository resourceRepository;
	
	@Override
	public Set<String> findPermissions(Set<Long> resourceIds) {
		Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            SysResource resource = resourceRepository.findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
	}

	@Override
	public List<SysResource> findMenus(Set<String> permissions) {
		  List<SysResource> allResources = resourceRepository.findAll();
	        List<SysResource> menus = new ArrayList<SysResource>();
	        for(SysResource resource : allResources) {
	            if(resource.isRootNode()) {
	                continue;
	            }
	            if(resource.getType() != SysResource.ResourceType.menu) {
	                continue;
	            }
	            if(!hasPermission(permissions, resource)) {
	                continue;
	            }
	            menus.add(resource);
	        }
	        return menus;
	}
    
	private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
