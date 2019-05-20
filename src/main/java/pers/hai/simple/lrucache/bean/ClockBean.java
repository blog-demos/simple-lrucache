package pers.hai.simple.lrucache.bean;

/**
 * Clock置换算法中用到的置换对象包装类
 *
 * Create Time: 2016/01/06
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class ClockBean {

    private boolean cleanFlag = false;
    
    private Object object = null;
    
    public ClockBean(Object _object, boolean _cleanFlag) {
        this.object = _object;
        this.cleanFlag = _cleanFlag;
    }

    public boolean isCleanFlag() {
        return cleanFlag;
    }

    public void setCleanFlag(boolean cleanFlag) {
        this.cleanFlag = cleanFlag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    @Override
    public String toString() {
        return object.toString();
    }
}
