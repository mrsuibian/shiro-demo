package com.qlexample.service;

import java.util.List;
import java.util.Set;

import com.qlexample.entity.SysResource;

public interface ResourceService {
    
	/**
	 * 
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Long> resourceIds);
    
	/**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<SysResource> findMenus(Set<String> permissions);
}
