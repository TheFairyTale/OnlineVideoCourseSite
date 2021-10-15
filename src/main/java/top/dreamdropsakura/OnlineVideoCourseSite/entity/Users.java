package top.dreamdropsakura.OnlineVideoCourseSite.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

// 加上@Data 后就不用为属性写get / set 和无参构造方法的代码了，lombok 会自动生成
@Data
public class Users {
    // 默认的主键生成策略为mp 自带策略（雪花算法），如果要更改生成策略则使用@TableId() 注解在字段id 上面
    // 不指定生成策略时则会自动识别id 字段类型并从mp 自带策略中采用相应生成策略
    /*
    IdType.AUTO          自动增长
    IdType.ASSIGN_ID
    IdType.ASSIGN_UUID
    IdType.ID_WORKER     mp 自带策略，生成一个19 位的值，如果id 字段为数值类型（如BIGINT、LONG、INT类型）时则可使用该策略
    IdType.ID_WORKER_STR mp 自带策略，生成一个19 位的值，如果id 字段为字符串类型时则可使用该策略
    IdType.INPUT         不自动生成id ，需要手动设置id 值
    IdType.NONE          不使用策略
    IdType.UUID          生成随机唯一id 值
    注意，当IdType 的类型为ID_WORKER、ID_WORKER_STR、UUID 时 主键由mp 的IdWorker 类生成 https://www.zhangshengrong.com/p/zAaOQo43Xd/
     */
    //@TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 使用mp 自动填充功能实现自动添加时间到数据表的字段中
	/*
	1. 在实体类中对要进行自动填充功能的属性添加注解@TableField()
	 */
    /*
    FieldFill.INSERT         插入填充字段
    FieldFill.DEFAULT        默认不处理
    FieldFill.INSERT_UPDATE  插入和更新填充字段
    FieldFill.UPDATE         更新填充字段
    */
    // 数据库字段create_time 等价于此处的createTime
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
