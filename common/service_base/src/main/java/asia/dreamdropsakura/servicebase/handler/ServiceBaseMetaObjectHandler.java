package asia.dreamdropsakura.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;

/**
 * <p>
 * 数据表字段自更新 公共组件
 * </p>
 *
 * @author TheFairyTale
 * @since 2021-12-09
 */
//@Component
public class ServiceBaseMetaObjectHandler implements MetaObjectHandler {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Logger logger = LogManager.getLogger("name");

    @Override
    public void insertFill(MetaObject metaObject) {
        // fieldName 数据表中的字段名称，不是实体类中的属性名称
        logger.info("insert start ...");
        //this.setFieldValByName("gmtCreate", new Date(), metaObject);
        //this.strictInsertFill(metaObject, "gmt_create", Date.class, new Date());
        //this.setFieldValByName("gmtModified", new Date(), metaObject);
        //this.strictInsertFill(metaObject, "gmtModified", Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("insert start ...");
        //this.setFieldValByName("gmtModified", dateFormat.format(DateFormat.getDateTimeInstance()), metaObject);
    }
}