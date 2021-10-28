package top.dreamdropsakura.OnlineVideoCourseSite.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

// https://mp.baomidou.com/guide/auto-fill-metainfo.html
// 根据文档，让该类实现MetaObjectHandler 接口 中的insertFill()、updateFill() 方法
// @Component 表将其交给Spring 进行管理
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 使用mp 实现的添加操作，在执行对数据表的添加操作时执行
    @Override
    public void insertFill(MetaObject metaObject) {
        // fieldName 是要设置的属性，在这里设置的是entity/Users 中的Date createTime
        // metaObject 元数据对象，
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
    }

    // 使用mp 实现的修改操作，在执行对数据表的修改操作时执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
