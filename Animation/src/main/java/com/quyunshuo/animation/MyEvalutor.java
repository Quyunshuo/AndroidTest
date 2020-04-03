package com.quyunshuo.animation;

import android.animation.TypeEvaluator;

/**
 * @Author: MiYan
 * @Time: 2019/8/6 11:13
 * @Description: 描述：
 */
public class MyEvalutor implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float v, Integer integer, Integer t1) {
        return (int) (200 + integer + v * (t1 - integer));
    }
}
