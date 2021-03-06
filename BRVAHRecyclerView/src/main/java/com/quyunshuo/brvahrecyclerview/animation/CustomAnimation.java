package com.quyunshuo.brvahrecyclerview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

import com.chad.library.adapter.base.animation.BaseAnimation;

/**
 * Customize Animation
 */
public class CustomAnimation implements BaseAnimation {

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.1f, 1),
                ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.1f, 1)
        };
    }
}
