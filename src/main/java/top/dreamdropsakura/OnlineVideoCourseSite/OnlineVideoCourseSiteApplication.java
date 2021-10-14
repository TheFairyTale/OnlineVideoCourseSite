package top.dreamdropsakura.OnlineVideoCourseSite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 可用于找到mapper 中的接口（？（括号内放mapper 的包名）
@MapperScan("top.dreamdropsakura.OnlineVideoCourseSite.mapper")
public class OnlineVideoCourseSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineVideoCourseSiteApplication.class, args);
	}

}
