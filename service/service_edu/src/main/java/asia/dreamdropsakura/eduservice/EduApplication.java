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
// @ComponentScan(basePackages = {}) 扫描指定的其他包中的类并加载(即定义要扫描的路径，从中找出标识了需要装配的类并自动装配到
// spring 的bean 容器中)。{} 为一个数组
@ComponentScan(basePackages = {"asia.dreamdropsakura"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
