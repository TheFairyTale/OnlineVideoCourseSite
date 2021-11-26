package asia.dreamdropsakura.eduservice.controller;


import asia.dreamdropsakura.eduservice.entity.EduTeacher;
import asia.dreamdropsakura.eduservice.service.IEduTeacherService;
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
     * @return List<EduTeacher>
     */
    @GetMapping("listAllTeacher")
    public List<EduTeacher> listAllTeacher() {
        // 调用service 的方法，实现查询所有老师
        // 由于IEduTeacherService 继承了IService，所以可以直接调方法。
        return teacherService.list();
    }

    // 逻辑删除讲师方法
    // 删除时根据id 删除，将参数写为{id} 则表明id 需要通过路径进行传递，路径通过函数参数注解@PathVariable 传递
    @DeleteMapping("{id}")
    public boolean deleteTeacher(@PathVariable String id) {
        return teacherService.removeById(id);
    }
}
