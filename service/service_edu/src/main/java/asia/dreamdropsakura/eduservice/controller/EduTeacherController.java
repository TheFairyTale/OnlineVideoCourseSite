package asia.dreamdropsakura.eduservice.controller;


import asia.dreamdropsakura.commonutils.R;
import asia.dreamdropsakura.commonutils.ReturnParam;
import asia.dreamdropsakura.eduservice.entity.EduTeacher;
import asia.dreamdropsakura.eduservice.service.IEduTeacherService;
import asia.dreamdropsakura.servicebase.SwaggerConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author TheFairyTale
 * @since 2021-11-23
 */
// 自swagger2 之后，要为控制器类添加描述，要先在swagger 配置类中定义"标签"并添加标签，然后在对应的控制器类中添加对应的标签即可
@Api(tags = {SwaggerConfig.EDU_TEACHER})
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    //0 在controller 中注入service -> 在对应的service 中注入mapper
    @Autowired
    private IEduTeacherService teacherService;

    // rest风格接口
    // @GetMapping("字符") 处理请求方法的GET类型

    /**
     * 查询讲师表的所有数据
     *
     * @return R
     */
    @GetMapping("listAllTeacher")
    // @ApiParam 用于为参数定义说明
    // @ApiOperation 用于为方法定义说明
    @ApiOperation(
            value = "listAllTeacher",
            tags = "列出所有讲师")
    public R listAllTeacher() {
        // 调用service 的方法，实现查询所有老师
        // 由于IEduTeacherService 继承了IService，所以可以直接调方法。
        return R.success().data(ReturnParam.ITEMS.toString(), teacherService.list());
    }

    /**
     * 删除讲师
     *
     * @param id
     * @return R
     */
    // 删除时根据id 删除，将参数写为{id} 则表明id 需要通过路径进行传递，路径通过函数参数注解@PathVariable 传递
    @DeleteMapping("{id}")
    @ApiOperation(
            value = "deleteTeacher",
            tags = "根据id 删除讲师")
    public R deleteTeacher(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        if (teacherService.removeById(id)) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 分页查询
     *
     * @return R
     */
    // 通过@GetMapping() 来传入参数 current 当前页，record 每页记录数
    @GetMapping("splitPageQuery/{currentPage}/{perPageRecords}")
    @ApiOperation(value = "splitPageQuery", tags = "根据当前页和每页记录数进行分页查询")
    // 通过@PathVariable 获取从@GetMapping() 传来的值
    public R splitPageQuery(
            @PathVariable long currentPage,
            @PathVariable long perPageRecords) {

        // 先创建page 对象, Page<>(当前页，每页记录数)
        Page<EduTeacher> splitPage = new Page<>(currentPage, perPageRecords);
        // 调用方法实现分页. page(Page集合类对象， 分页条件)。调用方法时，底层封装将分页所有数据封装到pageTeacher 对象里面。
        teacherService.page(splitPage, null);
        // 获取总记录数
        long total = splitPage.getTotal();
        // 数据list 集合
        List<EduTeacher> records = splitPage.getRecords();

        return R.success().data(ReturnParam.TOTAL.toString(), total).data(ReturnParam.ROWS.toString(), records);
    }
}
