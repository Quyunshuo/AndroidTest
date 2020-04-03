package com.quyunshuo.kotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*
import com.quyunshuo.kotlinandroid.Main2Activity as Main2Activity1

class Main2Activity : AppCompatActivity() {
    //声明可空类型时需在变量类型后加？
    val int3 = null

    var int: Int? = null
    val int2: Int = 2_0_0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
    }

    private fun initView() {
        button.setOnClickListener { textView.text = test5() }
//        Log.d("MiYan", "${int2.javaClass}")
//        test3()
        test4()
    }


    fun test() {
        //声明变量时要么指定变量类型要么赋初值
        var b1: Int
        val b2 = 1
        var b3: Long = b2.toLong()
    }

    private fun test2(): Unit {
        var result = ""
        for (a in 0..5) {
            val intVal = (Math.random() * 16 + 97).toInt()
            result += intVal.toChar()
        }
        val d1 = 1.1
        val d2 = d1.toInt()

        Log.d("MiYan", result)
        Log.d("MiYan", d2.toString())

    }

    fun test3(): Unit {
        val aStr: String = "MiYan"
        var bStr: String? = "MiYan"
        bStr?.let {
            var i = it.length
            Log.d("MiYan", i.toString())
        }

        var myTest4: () -> String
        var myTest5 = ::test5
    }

    private fun test4(): String {
//        var a: Int? = 1
//        a = null
//        val b = 2
//        val c = a ?: 3

        val str: String = """
            *1111111
                           *2222222
            *3333333
            
        """.trimMargin("*")
        Log.d("MiYan", str)
        return str
    }

    private fun test5() = "String" + "单表达式函数"
}
