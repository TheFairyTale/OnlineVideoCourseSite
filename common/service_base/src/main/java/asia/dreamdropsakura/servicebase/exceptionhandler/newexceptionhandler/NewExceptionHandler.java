package asia.dreamdropsakura.servicebase.exceptionhandler.newexceptionhandler;

import asia.dreamdropsakura.commonutils.ReturnCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NewExceptionHandler
 *
 * @author TheFairyTale
 * @since 2021/12/17
 */
@Data
// 生成有参构造方法
@AllArgsConstructor
// 生成无参构造方法
@NoArgsConstructor
public class NewExceptionHandler extends RuntimeException {
    // 状态码
    private ReturnCode code;

    // 异常信息
    private String msg;
}
