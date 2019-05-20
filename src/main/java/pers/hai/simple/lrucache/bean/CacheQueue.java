package pers.hai.simple.lrucache.bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class CacheQueue {

    private int maxSize = 0;
    private Queue<Object> queue = new LinkedList<>();
    
    public CacheQueue(int _maxSize) {
        maxSize = _maxSize;
    }
    
    public Object offer(Object object) {
        if (queue.size() < maxSize) {
            queue.offer(object);
            return null;
        }
        
        Object pollObject = poll();
        queue.offer(object);
        
        return pollObject;
    }
    
    public Object poll() {
        return queue.poll();
    }
    
    public void visiting(Object object) {
        if (queue == null) {
            throw new NullPointerException("Queue为空");
        }
        
        for (Object item : queue) {
            if (item.equals(object)) {
                queue.remove(item);
                break;
            }
        }
        
        queue.offer(object);
    }
    
    public boolean contains(Object object) {
        if (queue == null) {
            throw new NullPointerException("Queue为空");
        }
        
        return queue.contains(object);
    }
}
