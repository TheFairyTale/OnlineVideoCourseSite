package top.dreamdropsakura.OnlineVideoCourseSite.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 可用于找到mapper 中的接口（？（括号内放mapper 的包名）
@MapperScan("top.dreamdropsakura.OnlineVideoCourseSite.mapper")
public class MpConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        /*
         * 乐观锁插件
         */
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        /*
         * 分页插件
         */
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    // 3.1.1 以上版本不需要注册逻辑删除插件
}
