package asia.dreamdropsakura.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

// 统一返回结果类
// @Data 注解是lombok 注解，可以自动生成get set 方法
@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private ReturnCode code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    // 构造方法私有化：除了它自己其他类不能实例化该类
    private R() {
    }

    public static R success() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ReturnCode.SUCCESS);
        r.setMsg("成功");
        return r;
    }

    public static R failed() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ReturnCode.ERROR);
        r.setMsg("失败");
        return r;
    }

    public R success(boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R msg(String message) {
        this.setMsg(message);
        return this;
    }

    public R code(ReturnCode returnCode) {
        this.setCode(returnCode);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
