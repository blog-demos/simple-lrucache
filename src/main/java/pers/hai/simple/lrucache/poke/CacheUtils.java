package pers.hai.simple.lrucache.poke;

import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * 页面转换策略的包装类
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CacheUtils {

    private Cacheable cacheable = null;
    
    public CacheUtils(Cacheable _cacheable) {
        cacheable = _cacheable;
    }
    
    public void offer(Object object) {
        cacheable.offer(object);
    }
    
    public void visitting(Object object) {
        cacheable.visitting(object);
    }
    
    public void show() {
        cacheable.show();
    }
}
