package com.quyunshuo.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun gsonDemo() {
        println("==========>> 构造Gson对象 <<==========")
        // 构造Gson对象
        // 1. 通过构造函数
        val gson1 = Gson()
        // 2. 通过GsonBuilder，可以进行多项特殊配置
        val gson2 = GsonBuilder().create()
        println("=================================================================\n\n")


        println("==========>> 生成Json <<==========")
        // 生成Json
        val jsonObject = JsonObject().apply {
            addProperty("name", "quyunshuo")
            addProperty("age", 22)
            addProperty("height", 188.0F)
            addProperty("man", true)
        }
        val jsonObject2 = JsonObject().apply {
            addProperty("phone", "132********")
            addProperty("email", "quyunshuo@qq.com")
        }
        jsonObject.add("contact_details", jsonObject2)
        println(jsonObject)
        println("=================================================================\n\n")


        // Json与数组，List的转化
        val jsonArray = "[\"https://github.com\",\"https://www.jianshu.com\",\"Java\",\"Kotlin\",\"Git\",\"GitHub\"]"
        val gson3 = Gson()
        println("==========>> Json数组 转为 字符串数组 <<==========")
        // 1.1 Json数组 转为 字符串数组
        val strings = gson3.fromJson(jsonArray, Array<String>::class.java)
        strings.forEach { println(it) }
        println("=================================================================\n\n")
        println("==========>> 字符串数组 转为Json数组 <<==========")
        // 1.2 字符串数组 转为Json数组
        val toJson = gson3.toJson(jsonArray, object : TypeToken<String>() {}.type)
        println(toJson)
        println("=================================================================\n\n")
        println("==========>> Json数组 转为 List <<==========")
        // 2.1 Json数组 转为 List
        val stringList = gson3.fromJson<List<String>>(jsonArray, object : TypeToken<List<String>>() {}.type)
        println(stringList)
        println("=================================================================\n\n")
        println("==========>> List 转为 Json数组 <<==========")
        // 2.2 List 转为 Json数组
        val jsonArray2 = gson3.toJson(stringList, object : TypeToken<List<String>>() {}.type)
        println(jsonArray2)
        println("=================================================================\n\n")


        // 序列化与反序列化
        // Gson 也提供了 toJson() 和 fromJson() 两个方法用于转化 Model 与 Json，前者实现了序列化，后者实现了反序列化
        val gson4 = Gson()
        println("==========>> 序列化 <<==========")
        // 1. 序列化
        val user = UserBean("quyunshuo", 22, "quyunshuo@qq.com", true)
        val userJson = gson4.toJson(user)
        println(userJson)
        println("=================================================================\n\n")
        println("==========>> 反序列化 <<==========")
        // 2. 反序列化
        val fromJson = gson4.fromJson(userJson, UserBean::class.java)
        println(fromJson.toString())
        println("=================================================================\n\n")
    }
}