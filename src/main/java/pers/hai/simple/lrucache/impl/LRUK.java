package pers.hai.simple.lrucache.impl;

import java.util.ArrayList;
import java.util.List;

import pers.hai.simple.lrucache.bean.LRUHistory;
import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * LRU-K算法
 * 是LRU算法的改进版本
 *
 * Create Time: 2016/01/07
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class LRUK implements Cacheable {

    private int maxHistoryLength = 0;
    private int maxCacheLength = 0;
    private List<LRUHistory> histories = null;
    private List<Object> caches = null;
    private final int K = 2;
    
    public LRUK(int _maxHistoryLength, int _maxCacheLength) {
        this.maxHistoryLength = _maxHistoryLength;
        this.maxCacheLength = _maxCacheLength;
        
        initEvent();
    }
    
    @Override
    public void offer(Object object) {
        if (histories == null) {
            throw new NullPointerException();
        }
        
        if (histories.size() == maxHistoryLength) {
            cleanHistory();
        }
        
        LRUHistory history = new LRUHistory();
        history.setHash(object.hashCode());
        history.setTimes(1);
        
        histories.add(history);
    }

    @Override
    public void visitting(Object object) {
        if (histories == null) {
            throw new NullPointerException();
        }
        
        if (caches == null) {
            throw new NullPointerException();
        }
        
        int hashCode = object.hashCode();
        if (inHistory(hashCode)) {
            boolean offerCache = modifyHistory(hashCode);
            if (!offerCache) {
                return;
            }
            
            offerToCache(object);
        } else if (inCache(object)) {
            displace(object);
        } else {
            throw new NullPointerException("对象不存在");
        }
    }

    @Override
    public void show() {
        System.out.println(caches);
    }

    // init queue
    private void initEvent() {
        histories = new ArrayList<>(maxHistoryLength);
        caches = new ArrayList<>(maxCacheLength);
    }
    
    // clean history queue
    private void cleanHistory() {
        histories.remove(0);
    }
    
    // clean cache list
    private void cleanCache() {
        caches.remove(0);
    }
    
    // object is in history list or not 
    private boolean inHistory(int objectHash) {
        for (LRUHistory item : histories) {
            if (item.getHash() == objectHash) {
                return true;
            }
        }
        
        return false;
    }
    
    // object is in cache list or not
    private boolean inCache(Object object) {
        for (Object item : caches) {
            if (object.equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    // 修改历史记录列表信息
    private boolean modifyHistory(int objectHash) {
        for (LRUHistory item : histories) {
            if (item.getHash() != objectHash) {
                continue;
            }
            
            if (item.getTimes() + 1 < K) {
                item.setTimes(item.getTimes() + 1);
                histories.remove(item);
                histories.add(item);
                return false;
            }
            
            histories.remove(item);
            return true;
        }
        
        return false;
    }
    
    // 向缓存列表中添加一个新元素
    private void offerToCache(Object object) {
        if (caches == null) {
            throw new NullPointerException();
        }
        
        if (caches.size() == maxCacheLength) {
            cleanCache();
        }
        
        caches.add(object);
    }
    
    // 调整缓存队列中的元素顺序
    private void displace(Object object) {
        for (Object item : caches) {
            if (item.equals(object)) {
                caches.remove(item);
                break;
            }
        }
        
        caches.add(object);
    }
}
