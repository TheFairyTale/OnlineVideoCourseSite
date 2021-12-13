package asia.dreamdropsakura.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TheFairyTale
 */
@Data
public class TeacherQuery {
    @ApiModelProperty(value = "教师名称, 模糊查询")
    private String name;

    @ApiModelProperty(value = "讲师级别 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2021-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2021-01-01 10:10:10")
    private String end;
}
