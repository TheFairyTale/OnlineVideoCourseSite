package top.dreamdropsakura.OnlineVideoCourseSite;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.dreamdropsakura.OnlineVideoCourseSite.entity.Users;
import top.dreamdropsakura.OnlineVideoCourseSite.mapper.UserMapper;

import java.util.Arrays;
import java.util.HashMap;
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
        users.setName("baobao");
        users.setAge(19);
        users.setEmail("baobao@baomidou.com");

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

    // 测试乐观锁
    @Test
    public void testOptimisticLocker() {
        // 根据id 查询数据
        // 要使乐观锁生效，必须要先查询，然后再拿查询结果去修改。而不是直接上来就修改
        Users users = userMapper.selectById(1453695089562202114L);

        // 然后修改
        users.setAge(200);
        userMapper.updateById(users);
    }

    // 多个id 批量查询
    @Test
    public void testSelectDemo1() {
        List<Users> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    // Hashmap 根据条件做查询
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        // 根据name、age 的值来做查询。当同时满足指定字段的指定值时返回数据
        objectObjectHashMap.put("name", "Jone");
        objectObjectHashMap.put("age", 18);
        List<Users> users = userMapper.selectByMap(objectObjectHashMap);

        users.forEach(System.out::println);
    }

    // 分页查询
    @Test
    public void testPage() {
        //1. 创建page对象, 并传入参数current: 当前页; size: 每页要显示多少项
        Page<Users> usersPage = new Page<>(1, 3);
        //2. 调用mp 分页查询方法。
        //调用mp 分页查询方法时，底层封装会将分页所有数据 封装到 page 对象中
        userMapper.selectPage(usersPage, null);

        //3. 获取分页数据
        // 当前页
        System.out.println(usersPage.getCurrent());
        // 每页数据的list 集合
        System.out.println(usersPage.getRecords());
        // 每页显示记录数
        System.out.println(usersPage.getSize());
        // 获取表中所有的记录数
        System.out.println(usersPage.getTotal());
        // 获取总页数
        System.out.println(usersPage.getPages());

        // 是否有下一页
        System.out.println(usersPage.hasNext());
        // 是否有上一页
        System.out.println(usersPage.hasPrevious());
    }

    // 逻辑删除操作
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1456204680991469570L);
        System.out.println(result);
    }

    // 批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(4, 5, 10));
        System.out.println(result);
    }
}
