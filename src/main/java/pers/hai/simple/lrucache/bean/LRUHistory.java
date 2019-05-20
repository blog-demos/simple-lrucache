package pers.hai.simple.lrucache.bean;

/**
 * 在LRU-K算法中历史列表项
 *
 * Create Time: 2016/01/07
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LRUHistory {

    private int hash; // 资源对象的Hash值
    
    private int times; // 资源的使用次数

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
    
}
