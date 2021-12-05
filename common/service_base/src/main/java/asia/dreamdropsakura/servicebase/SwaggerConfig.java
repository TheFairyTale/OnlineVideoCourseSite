package asia.dreamdropsakura.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
// 表示它是配置类
@Configuration
public class SwaggerConfig {
    // 自swagger2 之后，要为控制器类添加描述，要先在swagger 配置类中定义"标签"并添加标签，然后在对应的控制器类中添加对应的标签即可
    public static final String EDU_TEACHER = "讲师管理模块";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("本文档描述课程中心微服务接口定义")
                .version("1.0.0")
                .contact(new Contact("java", "//127.0.0.1", ""))
                .build();
    }

    /**
     * Swagger 插件
     *
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket createRestApi() {
        // DocumentationType 类型
        return new Docket(DocumentationType.SWAGGER_2)
                // 分组名称（可以随便起）
                .groupName("webApi")
                .select()
                // 这里写的是API接口所在的包位置
                // 如果访问swagger 页面后发现没任何接口的文档，那可能是这里的包位置写错了
                .apis(RequestHandlerSelectors.basePackage("asia.dreamdropsakura"))
                // 路径中包含以下内容时则不显示
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                //
                .paths(PathSelectors.any())
                .build()
                // 设置在线文档的信息
                .apiInfo(apiInfo())
                // 定义"标签"并添加标签
                .tags(new Tag("EduTeacherController", EDU_TEACHER));
    }
}