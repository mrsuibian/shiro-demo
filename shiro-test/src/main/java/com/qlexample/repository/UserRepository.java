package com.qlexample.repository;


import org.springframework.data.jpa.repository.Query;

import com.qlexample.entity.SysUser;

public interface UserRepository extends BaseRepository<SysUser, Long>{
    
	@Query("select p from SysUser p where p.username=?1")
	SysUser findByUserName(String username);
}
