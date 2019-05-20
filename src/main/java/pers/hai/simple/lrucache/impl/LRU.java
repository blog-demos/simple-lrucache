package pers.hai.simple.lrucache.impl;

import java.util.LinkedList;
import java.util.Queue;

import pers.hai.simple.lrucache.excp.ObjectExsitException;
import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * 最近最久未使用(LRU)置换算法
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LRU implements Cacheable {

    private int maxLength = 0;
    private Queue<Object> mQueue = null;
    
    public LRU(int _maxLength) {
        maxLength = _maxLength;
        initEvent();
    }
    
    @Override
    public void offer(Object object) {
        if (mQueue == null) {
            throw new NullPointerException("策略队列对象为空");
        }
        
        // check is need swap or not
        if (mQueue.size() == maxLength) {
            clean();
        }
        
        mQueue.offer(object);
    }
    
    

    @Override
    public void visitting(Object object) {
        if (mQueue == null || mQueue.isEmpty()) {
            throw new NullPointerException("访问对象不存在");
        }
        
        System.out.println("Visited " + object);
        displace(object);
    }
    
    @Override
    public void show() {
        System.out.println(mQueue);
    }
    
    private void initEvent() throws ObjectExsitException {
        if (mQueue != null) {
            throw new ObjectExsitException("当前策略中已存在数据");
        }
        
        mQueue = new LinkedList<>();
    }
    
    // remove the longer no visit
    private void clean() {
        mQueue.poll();
    }

    // cache core code
    private void displace(Object object) {
        for (Object tmp : mQueue) {
            if (object.equals(tmp)) {
                mQueue.remove(tmp);
                break;
            }
        }
        
        mQueue.offer(object);
    }
}
