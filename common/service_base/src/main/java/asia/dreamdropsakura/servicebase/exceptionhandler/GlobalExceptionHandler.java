package asia.dreamdropsakura.servicebase.exceptionhandler;

import asia.dreamdropsakura.commonutils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一错误处理类
 *
 * @author TheFairyTale
 */
public class GlobalExceptionHandler {

    /**
     * 发生异常时执行
     * 在此处添加ResponseBody 是为了返回异常提示语句(R.msg())
     *
     * @param e 包含所有异常（Exception.class）
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.failed().msg("Global error invoked, Please check code if anywhere has problems.");
    }
}
