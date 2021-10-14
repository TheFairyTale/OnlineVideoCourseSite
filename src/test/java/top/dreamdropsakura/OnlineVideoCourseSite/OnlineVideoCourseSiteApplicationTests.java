package top.dreamdropsakura.OnlineVideoCourseSite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dreamdropsakura.OnlineVideoCourseSite.entity.User;
import top.dreamdropsakura.OnlineVideoCourseSite.mapper.UserMapper;

import java.util.List;

@SpringBootTest
class OnlineVideoCourseSiteApplicationTests {

	// 单元测试
	// 利用单元测试，将mapper 做最终实现

	// 注入mapper，因为control 注入service, service 注入mapper，因此需要注入mapper（？
	@Autowired
	private UserMapper userMapper;

	// 测试第一个功能
	// 查询User 表中所有数据
	@Test
	public void findAll() {
		// queryWrapper: 查询条件
		final List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	@Test
	void contextLoads() {
	}

}
