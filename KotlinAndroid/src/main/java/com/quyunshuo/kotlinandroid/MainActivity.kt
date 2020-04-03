package com.quyunshuo.kotlinandroid

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
//        initAnimator()
//        test()
        whileTest()
        Log.d("MiYan", wenTest("3"))

    }

    private fun test() {

    }

    private fun initView() {
        text_view.setText(sum(10, 5))
        text_view.setOnClickListener { view ->
            //            initAnimator()
//            text_view.setText(splice("This ", "is ", "Kotlin"))
            text_view.setText(maxOf(3, 5).toString())

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

    /**
     * 作为表达式的写法
     */
    private fun maxOf(a: Int, b: Int): Int = if (a > b) a else b

    private fun whileTest() {
        var items = listOf<String>("1", "2", "3")
        for (item in items) {
            Log.d("MiYan", item)
        }

        //返回索引
        for (index in items.indices) {
            Log.d("MiYan", "item at $index is ${items[index]}")
        }
        var a = 1
        var b = 2

        val c = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        Log.d("MiYan", c.toString())
    }

    private fun wenTest(str: String): String {
        val string = when (str) {
            "1" -> "1"
            "2" -> "2"
            else -> "无"
        }
        return string
    }
}