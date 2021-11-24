package asia.dreamdropsakura.eduservice.controller;


import asia.dreamdropsakura.eduservice.entity.EduTeacher;
import asia.dreamdropsakura.eduservice.service.IEduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // @GetMapping("可以起个名字") 表示用Get 提交

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

}
