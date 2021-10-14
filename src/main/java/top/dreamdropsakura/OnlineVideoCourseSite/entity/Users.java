package top.dreamdropsakura.OnlineVideoCourseSite.entity;

import lombok.Data;

// 加上@Data 后就不用为属性写get / set 和无参构造方法的代码了，lombok 会自动生成
@Data
public class Users {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
