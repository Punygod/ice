package xyz.welog.kevin.exception;

/**
 * 功能描述:
 * 〈权限异常〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 14:24
 */
public class PermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PermissionException(String msg) {
        super(msg);
    }
}
