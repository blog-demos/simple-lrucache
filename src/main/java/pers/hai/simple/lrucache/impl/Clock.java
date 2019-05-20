package pers.hai.simple.lrucache.impl;

import java.util.ArrayList;
import java.util.List;

import pers.hai.simple.lrucache.bean.ClockBean;
import pers.hai.simple.lrucache.interf.Cacheable;

/**
 * Clock置换算法
 *
 * Create Time: 2016/01/05
 * Last Modify: 2019/05/20
 * 
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class Clock implements Cacheable {

    private int maxLength = 0;
    private List<ClockBean> list = null;
    private int index = 0;

    public Clock(int _maxLength) {
        maxLength = _maxLength;
        initEvent(maxLength);
    }

    @Override
    public void offer(Object object) {
        if (list == null) {
            throw new NullPointerException("策略队列对象为空");
        }

        if (list.size() == maxLength) {
            clean();
        } else {
            index = (index + 1 + maxLength) % maxLength;
        }

        list.add((ClockBean) object);
    }

    @Override
    public void visitting(Object object) {
        if (object instanceof ClockBean) {
            ClockBean bean = (ClockBean) object;
            
            for (int i = 0; i < list.size(); i++) {
                if (bean == list.get(i)) {
                    list.get(i).setCleanFlag(false);
                    index = (i + 1 + maxLength) % maxLength;
                }
            }
        } else {
            System.err.println("Error Type");
        }
    }

    @Override
    public void show() {
        System.out.println(list);
    }

    //
    private void initEvent(int _maxLength) {
        if (list != null) {
            return;
        }

        list = new ArrayList<>(_maxLength);
    }

    // 移除待置换的对象
    private void clean() {
        ClockBean bean = list.get(index);
        
        if (bean == null) {
            throw new NullPointerException();
        }
        
        if (bean.isCleanFlag()) {
            list.remove(index);
            return;
        }
        
        bean.setCleanFlag(true);
        
//        index = (index + 1 + maxLength) % maxLength;
        clean();
    }
}
