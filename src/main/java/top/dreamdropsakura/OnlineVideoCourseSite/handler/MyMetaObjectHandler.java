package top.dreamdropsakura.OnlineVideoCourseSite.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

// https://mp.baomidou.com/guide/auto-fill-metainfo.html
// 根据文档，让该类实现MetaObjectHandler 接口 中的insertFill()、updateFill() 方法
// @Component 表将其交给Spring 进行管理
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
