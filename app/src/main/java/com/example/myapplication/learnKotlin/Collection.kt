package com.example.myapplication.learnKotlin

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    // set 集合的创建和获取
    var setList: Set<String> = setOf("jerry","jack","tony","jerry")
    println(setList.elementAt(2)) //tony
    // set 可变
    var mutableSet = mutableSetOf<String>("jerry","tony","mike")
    mutableSet.add("Tom")
    println(mutableSet) // [jerry, tony, mike, Tom]
    // 利用set对list去重
    val list = listOf<String>("hello","world","hello")
    println(list.toSet().toList()) // [hello, world]
    // 也可以利用 distinct() 方法去重
    val list2 = listOf<String>("hello","world","hello","hhh")
    println(list2.distinct()) // [hello, world, hhh]
    // map 集合的创建和获取
    val map = mapOf<Int,String>(1 to "hello",2 to "world")
    // 也可以这样创建
    val map2 = mapOf(Pair(1,"hello"), Pair(2,"world"), Pair(3,"hhh"))
    // map 的获取
    println(map[1]+"---"+ map+"${map.getValue(1)}---${map.getOrDefault(3,"没有3这个键值")}")
    // hello---{1=hello, 2=world}hello---没有3这个键值
    println(map2[2]+"---"+ map2) // world---{1=hello, 2=world, 3=hhh}
    // map的遍历
    map2.forEach {
        println("${it.key}-----${it.value}")
    }
    map.forEach{(key:Int,value:String) ->
        println("$key---$value")
    }
    // 创建可变的map集合
    var mutableMap = mutableMapOf<String,String>("hello" to "你好","world" to "世界")
    mutableMap.put("tony","我是托尼")
    mutableMap["hhh"] = "哈哈哈"
    println(mutableMap) // {hello=你好, world=世界, hhh=哈哈哈}
    println(mutableMap["tony"])

}