package asia.dreamdropsakura.eduservice.controller;


import asia.dreamdropsakura.eduservice.service.IEduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //1 查询讲师表所有数据

}

