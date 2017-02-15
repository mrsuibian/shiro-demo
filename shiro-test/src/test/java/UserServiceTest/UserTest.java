package UserServiceTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qlexample.dao.UserDao;
import com.qlexample.entity.SysUser;
import com.qlexample.repository.SysRoleRepository;
import com.qlexample.service.ResourceService;
import com.qlexample.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserTest {
    
	@Resource
	private UserDao userDao;
//	
	@Resource
	private SysRoleRepository roleRepository;
//	
//	@Resource
//	private SysResourceRepository resourceRepository;
//	
//	@Resource
//	private SysOrganizationRepository orgRepository;
//	
//	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Test
	public void findUser(){
		System.out.println(userService.findByUserName("秦岭"));
	}
	
	@Test
	public void saveUser(){
		SysUser user = new SysUser();
		user.setUsername("秦岭");
		user.setPassword("123");
		user.setSalt("aslkdjfqejrlsdf");
		user.setRoleIds("teacher");
		user.setLocked(0);
		userDao.save(user);
	}
	
	@Test
	public void findRole(){
//		System.out.println(userService.findRoleByUserName("admin"));
//		System.out.println(roleRepository.findOne(1L));
//		System.out.println(userService.findPermissionByUserName("admin"));
		System.out.println(resourceService.findMenus(userService.findPermissionByUserName("admin")));
	}
//	
//	@Test
//	public void saveSysRole(){
//       	SysRole sysRole = new SysRole();
//       	sysRole.setRole("学生");
//       	sysRole.setDescription("代表学生");
//       	sysRole.setResourceIds("234");
//       	sysRole.setAvailable(true);
//       	roleRepository.save(sysRole);
//	}
//	
//	@Test
//	public void saveSysResource(){
//		SysResource sysResource = new SysResource();
//		sysResource.setName("菜单二");
//		sysResource.setType("菜单");
//		sysResource.setPriority(2);
//		sysResource.setParentId(2L);
//		sysResource.setUrl("/resource");
//		sysResource.setParentIds("1,2,3");
//		sysResource.setPermission("open");
//		sysResource.setAvailable(true);
//		resourceRepository.save(sysResource);
//	}
//	
//	@Test
//	public void saveSysOrg(){
//		SysOrganization sysOrganization =  new SysOrganization();
//		sysOrganization.setName("学校");
//		sysOrganization.setPriority(4);
//		sysOrganization.setParentId(3L);
//		sysOrganization.setParentIds("4,5,2");
//		sysOrganization.setAvailable(true);
//		orgRepository.save(sysOrganization);
//	}
}
