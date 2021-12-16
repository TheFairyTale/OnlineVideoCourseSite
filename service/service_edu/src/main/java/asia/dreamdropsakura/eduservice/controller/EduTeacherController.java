package asia.dreamdropsakura.eduservice.controller;


import asia.dreamdropsakura.commonutils.R;
import asia.dreamdropsakura.commonutils.ReturnParam;
import asia.dreamdropsakura.eduservice.entity.EduTeacher;
import asia.dreamdropsakura.eduservice.entity.vo.TeacherQuery;
import asia.dreamdropsakura.eduservice.service.IEduTeacherService;
import asia.dreamdropsakura.servicebase.SwaggerConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
@Api(SwaggerConfig.EDU_TEACHER)
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    //0 在controller 中注入service -> 在对应的service 中注入mapper
    @Autowired
    private IEduTeacherService teacherService;

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
     * @param id 讲师uuid
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
     * @param currentPage    当前页
     * @param perPageRecords 每页记录数
     * @return R
     */
    // rest风格接口
    // @GetMapping("字符") 处理请求方法的GET类型
    // 通过@GetMapping() 来传入参数
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

    /**
     * 多条件组合查询(动态sql：用xml 拼接SQL语句) 带分页方法
     *
     * @param theCurrentPage 当前页
     * @param perPageRecords 每页记录数
     * @param teacherQuery   封装的对象，其中包含条件查询方法所需的条件值
     * @return R
     */
    //@GetMapping("pageTeacherCondition/{theCurrentPage}/{perPageRecords}")
    @PostMapping("pageTeacherCondition/{theCurrentPage}/{perPageRecords}")
    @ApiOperation(value = "pageTeacherCondition", tags = "多条件组合查询带分页方法: 根据条件查询记录并分页")
    public R pageTeacherCondition(
            @PathVariable long theCurrentPage,
            @PathVariable long perPageRecords,
            // @ResponseBody 用于返回json 数据
            // @RequestBody 使该参数以json 格式返回数据并封装至对应对象当中, required = false 不强制要求有值
            @RequestBody(required = false) TeacherQuery teacherQuery) {

        // todo: 实际上，service 应为业务逻辑层，这里不应该放这么多逻辑。

        // 创建page 对象
        Page<EduTeacher> teacherPage = new Page<>(theCurrentPage, perPageRecords);
        // 使用QueryWrapper 编辑并构建查询条件
        QueryWrapper<EduTeacher> teacherQueryWrapper = new QueryWrapper<>();

        // 1. 取出teacherQuery 对象中的查询值
        // 讲师名
        String teacherName = teacherQuery.getName();
        // 讲师级别
        Integer teacherLevel = teacherQuery.getLevel();
        // 讲师注册时间
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        // 2. 判断条件值是否为空，如果不为空则拼接条件
        if (StringUtils.hasLength(teacherName)) {
            teacherQueryWrapper.like("name", teacherName);
        } else if (!ObjectUtils.isEmpty(teacherLevel)) {
            teacherQueryWrapper.eq("level", teacherLevel);
        } else if (StringUtils.hasLength(begin)) {
            teacherQueryWrapper.ge("gmt_create", begin);
        } else if (StringUtils.hasLength(end)) {
            teacherQueryWrapper.le("gmt_modified", end);
        }

        // 实现条件查询分页
        teacherService.page(teacherPage, teacherQueryWrapper);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();

        return R.success().data(ReturnParam.TOTAL.toString(), total).data(ReturnParam.ITEMS.toString(), records);
    }

    /**
     * 新增讲师接口
     *
     * @param eduTeacher EduTeacher 实体类对象
     * @return R
     */
    @ApiOperation(value = "addTeacher", tags = "新增讲师接口")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        if (teacherService.save(eduTeacher)) {
            return R.success();
        }
        return R.failed();
    }

    /**
     * 根据讲师id 进行查询
     *
     * @param id 讲师uuid
     * @return R
     */
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
        return R.success().data("teacher", teacherService.getById(id));
    }

    /**
     * 讲师修改功能
     */
    // 使用PostMapping 可以通过提交一整个实体类的值（其中包含该功能需要的信息，如id）来修改，不需要在方法里手动调方法添加id 来修改
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduteacher) {
        if (teacherService.updateById(eduteacher)) {
            return R.success();
        }
        return R.failed();
    }
}
