package asia.dreamdropsakura.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author TheFairyTale
 * @since 2021-11-23
 */
@Data
/**
 * 用来配置lombok如何产生和显示getters和setters的 注解,可以用在类或方法属性上面。
 * 有三种类型fluent 布尔型、chain 布尔型、prefix String型
 *
 * fluent 表示生成的setter和getter方法没有前缀set和get，且setter方法返回的是当前对象。
 * 即生成的getter方法不是getId(){}，而是id(){}；setter方法不是void setId(){}，而是Person id(int id){}
 * 当fluent 为true 时，chain 也为true
 *
 * chain 生成的setter方法是void类型；方法返回this（当前对象）
 *
 */
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "EduTeacher对象", description = "讲师")
public class EduTeacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "讲师id")
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历， 一句话说明讲师")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    // @TableLogic 标明该值需要做逻辑删除
    @ApiModelProperty(value = "逻辑删除 1(true) 已删除 0(false) 未删除")
    @TableLogic
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Timestamp gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Timestamp gmtModified;
}
