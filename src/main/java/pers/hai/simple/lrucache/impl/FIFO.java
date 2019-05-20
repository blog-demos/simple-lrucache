package pers.hai.simple.lrucache.impl;

import java.util.LinkedList;
import java.util.Queue;

import pers.hai.simple.lrucache.excp.ObjectExsitException;
import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * 先进先出(FIFO)页面置换算法
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FIFO implements Cacheable {

    private int maxLength = 0;
    private Queue<Object> mQueue = null;
    
    public FIFO(int _maxLength) {
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
        System.out.println("Visited " + object);
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
    
    private void clean() {
        mQueue.poll();
    }
}
