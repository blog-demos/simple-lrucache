package pers.hai.simple.lrucache.excp;

/**
 * 对象已存在异常
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ObjectExsitException extends RuntimeException {

    private static final long serialVersionUID = 2450411957406354483L;

    public ObjectExsitException(String msg) {
        super(msg);
    }
    
    public ObjectExsitException(Throwable cause) {
        super(cause);
    }
    
    public ObjectExsitException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
}
