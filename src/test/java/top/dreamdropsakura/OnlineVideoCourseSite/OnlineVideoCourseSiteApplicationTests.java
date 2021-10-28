package top.dreamdropsakura.OnlineVideoCourseSite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dreamdropsakura.OnlineVideoCourseSite.entity.Users;
import top.dreamdropsakura.OnlineVideoCourseSite.mapper.UserMapper;

import java.util.List;

@SpringBootTest
class OnlineVideoCourseSiteApplicationTests {

    // 单元测试
    // 利用单元测试，将mapper 做最终实现

    // 注入mapper，因为control 注入service, service 注入mapper，因此需要注入mapper（？
    @Autowired
    private UserMapper userMapper;

    // 测试第一个增删查改功能
    // 查询users 表中所有数据
    // 注意，类Users 在被指定为表名来做数据库操作时，会被自动转为全小写users
    @Test
    public void findAll() {
        // queryWrapper: 查询条件
        final List<Users> users = userMapper.selectList(null);
        //final List<User> users = userMapper.deleteById();
        System.out.println(users);
    }

    // 测试添加用户功能
    // 添加用户到users 表操作
    @Test
    public void addUser() {
        // 不需要手动设置id ，mp 会自己生成（19位的id ）
        // 在mariadb 中，数据类型BIGINT 就是Long
		/*
		 常见的主键生成策略（数据表的主键生成方式）
		 参考链接：https://www.cnblogs.com/haoxinyue/p/5208136.html
		 1.自动增长（AUTO_INCREMENT），每次的值都会自动生成。但在分库分表操作中，如果旧表最后一个id 为10000，那么新表在生成新的id 时需要先
		 得到旧表的id 并+1 才能生成新表id
		 2.UUID，每次操作生成一个随机的、唯一的数值。好处是新表生成id 时和旧表的id 或者上一个id 是无关联的。缺点是它是随机值，不能排序，不连续
		 3.redis 原子操作，（看链接）
		 4.mp 自带生成策略，生成19 位的值。每次生成都可以唯一。使用的是snowflake 算法（使用41bit 作为毫秒数，10bit 作为机器的ID （5个bit
		 是数据中心，5个bit的机器ID ），12bit 作为毫秒内的流水号（意味着每个节点在每毫秒可以产生4096 个ID ），最后还有一个符号位，永远是0 ）
		 。（具体看链接）
		 */
        Users users = new Users();
        users.setName("RAIDEN SHOUGUN");
        users.setAge(20);
        users.setEmail("mihouyo@mihouyo.com");

        // 手动设置时间戳
        //users.setCreateTime(new Date());
        //users.setUpdateTime(new Date());

        // 自动添加时间：mp 自动填充

        final int insert = userMapper.insert(users);
        System.out.println("INSERT : " + insert);
    }

    // 测试修改或更新用户数据功能
    @Test
    public void updateUser() {
        Users users = new Users();

        // 由于是根据id 来修改目标用户，故需要传入id
        users.setId(1453259220391628802L);
        users.setAge(22);

        final int row = userMapper.updateById(users);
        System.out.println(row);
    }

    @Test
    void contextLoads() {
    }

}
