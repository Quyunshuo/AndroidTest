package com.quyunshuo.kotlinandroid

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
//        initAnimator()
        test()
    }

    private fun test() {

    }

    private fun initView() {
        text_view.setText(sum(10, 5))
        text_view.setOnClickListener { view ->
            initAnimator()
            text_view.setText(splice("This ", "is ", "Kotlin"))

        }
    }

    private fun initAnimator() {
        var mObjectAnimator = ObjectAnimator.ofFloat(text_view, "rotation", 0f, 360f)
        mObjectAnimator.setDuration(1000)
        mObjectAnimator.start()
    }
//    fun sum(a: Int, b: Int): Int {
//        return a + b
//    }
//
//    fun main() {
//        print("sum of 3 and 5 is ")
//        println(sum(3, 5))
//    }

    private fun sum(a: Int, b: Int): String {
        var i = a + b
        return i.toString()
    }

    /**
     * 拼接字符串
     */
    private fun splice(s: String, t: String, r: String): String {
        val str: String = s + t + r
        return str
    }
}