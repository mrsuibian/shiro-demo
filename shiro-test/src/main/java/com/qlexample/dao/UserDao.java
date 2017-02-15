package com.qlexample.dao;

import com.qlexample.entity.SysUser;

public interface UserDao {
    SysUser findByName(String name);
    SysUser save(SysUser user);
}
