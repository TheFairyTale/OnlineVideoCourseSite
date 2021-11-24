package asia.dreamdropsakura.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 写一个@MapperScan 来让它扫描到mapper 接口。可以写在启动类上，但一般最好写在配置类中。
// @MapperScan("mapper interface 类的包的地址。例如asia.dreamdropsakura.eduservice.mapper。用的类是eduservice 包下的mapper/EduTeacherMapper.java")
@MapperScan("asia.dreamdropsakura.eduservice.mapper")
public class EduConfig {

}
