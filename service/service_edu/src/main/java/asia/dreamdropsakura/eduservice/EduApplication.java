package asia.dreamdropsakura.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目组件启动类
 *
 * @author TheFairyTale
 */
@SpringBootApplication
// @ComponentScan(basePackages = {}) 扫描指定的其他包中的类并加载(加载注解了@Component 的类并装配到spring 的bean 容器中)。
// {} 代表一个数组
@ComponentScan(basePackages = {"asia.dreamdropsakura"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
