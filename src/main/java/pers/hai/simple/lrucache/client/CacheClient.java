package pers.hai.simple.lrucache.client;

import pers.hai.simple.lrucache.impl.LRUK;
import pers.hai.simple.lrucache.poke.CacheUtils;

/**
 * 页面转换算法客户端调用
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CacheClient {

    public static void main(String[] args) {
        CacheUtils cacheUtils = new CacheUtils(new LRUK(5, 5));
        
        cacheUtils.offer("A");
        cacheUtils.offer("B");
        cacheUtils.offer("C");
        cacheUtils.offer("D");
        cacheUtils.offer("E");
        
        cacheUtils.visitting("D");
        cacheUtils.visitting("A");
        cacheUtils.visitting("B");
        cacheUtils.visitting("A");
        cacheUtils.visitting("C");
        cacheUtils.visitting("E");
        
        cacheUtils.offer("F");
        cacheUtils.offer("G");
        cacheUtils.offer("H");
        cacheUtils.offer("I");
        cacheUtils.offer("J");
        
        cacheUtils.visitting("J");
        
        cacheUtils.show();
    }
}
