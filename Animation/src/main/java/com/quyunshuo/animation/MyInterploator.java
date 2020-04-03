package com.quyunshuo.animation;

import android.animation.TimeInterpolator;

/**
 * @Author: MiYan
 * @Time: 2019/8/6 10:59
 * @Description: 描述：
 */
public class MyInterploator implements TimeInterpolator {
    @Override
    public float getInterpolation(float v) {
        return 1 - v;
    }
}
