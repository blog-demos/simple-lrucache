package pers.hai.simple.lrucache.impl;

import java.util.ArrayList;
import java.util.List;

import pers.hai.simple.lrucache.bean.CacheQueue;
import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * TODO
 *
 * Create Time: 2016/01/07
 * Last Modify: 2019/05/20
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class MultiQueue implements Cacheable {

    private int maxMultiQueueSize = 0;
    private int maxCacheQueueSize = 0;
    private final int PK = 5;
    private List<CacheQueue> multiQueueList = null;
    private CacheQueue cacheQueue = null;
    
    public MultiQueue(int _maxMultiQueueSize, int _maxCacheQueueSize) {
        this.maxMultiQueueSize = _maxMultiQueueSize;
        this.maxCacheQueueSize = _maxCacheQueueSize;
        
        initEvent();
    }
    
    @Override
    public void offer(Object object) {
        // TODO Auto-generated method stub
        if (isNewObject(object)) {
            multiQueueList.get(0).offer(object);
            // TODO
        }
    }

    @Override
    public void visitting(Object object) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        System.out.println(cacheQueue);
    }

    private void initEvent() {
        cacheQueue = new CacheQueue(maxCacheQueueSize);
        multiQueueList = new ArrayList<>(PK);
        for (int i = 0; i < PK; i++) {
            multiQueueList.add(new CacheQueue(maxMultiQueueSize));
        }
    }
    
    private boolean isNewObject(Object object) {
        if (cacheQueue.contains(object)) {
            return true;
        }
        
        for (CacheQueue item : multiQueueList) {
            if (item.contains(object)) {
                return true;
            }
        }
        
        return false;
    }
    
    private void offerToList(Object object) {
        
    }
}
