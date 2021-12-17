package asia.dreamdropsakura.servicebase.exceptionhandler;

import asia.dreamdropsakura.commonutils.R;
import asia.dreamdropsakura.servicebase.exceptionhandler.newexceptionhandler.NewExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一错误处理类
 *
 * @author TheFairyTale
 */
public class GlobalExceptionHandler {

    /**
     * 全局异常提示
     * 在此处添加ResponseBody 是为了返回异常提示语句(R.msg())
     *
     * @param e 包含所有异常（Exception.class）
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.failed().msg("Global error invoked, please check code if anywhere has problems.");
    }

    // 特定异常提示
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e) {
        e.printStackTrace();
        return R.failed().msg("NullPointerException error invoked, please check code if anywhere has problems.");
    }

    // 自定义异常
    @ExceptionHandler(NewExceptionHandler.class)
    @ResponseBody
    public R error(NewExceptionHandler e) {
        e.printStackTrace();
        return R.failed().code(e.getCode()).msg(e.getMsg());
    }
}
