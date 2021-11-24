package asia.dreamdropsakura.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @MapperScan("mapper interface 类的包的地址。例如asia.dreamdropsakura.eduservice.mapper。用的类是eduservice 包下的mapper/EduTeacherMapper.java")
@MapperScan("asia.dreamdropsakura.eduservice.mapper")
public class EduConfig {

}
