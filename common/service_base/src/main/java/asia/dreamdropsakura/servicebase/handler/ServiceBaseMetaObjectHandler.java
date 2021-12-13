package asia.dreamdropsakura.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 数据表字段自更新 公共组件
 * </p>
 *
 * @author TheFairyTale
 * @since 2021-12-09
 */
@Component
public class ServiceBaseMetaObjectHandler implements MetaObjectHandler {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void insertFill(MetaObject metaObject) {
        // fieldName 类的属性名称
        // todo ERROR: argument type mismatch
        this.setFieldValByName("gmtCreate", dateFormat.format(new Date()), metaObject);
        this.setFieldValByName("gmtModified", dateFormat.format(new Date()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", dateFormat.format(new Date()), metaObject);
    }
}