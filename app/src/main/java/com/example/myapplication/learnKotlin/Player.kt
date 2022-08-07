package com.example.myapplication.learnKotlin

import kotlin.math.absoluteValue

class Player {
    var name:String = "jack"
    // kotlin 内置了一个field 关键字
    get() = field.capitalize()
    set(value)  {
        field = value.trim()
    }
}
class Student(name:String){
    var name = name
//    val config by lazy { loadConfig() } 加lazy 是当用到这个变量的时候执行
    val config = loadConfig() // loading 会一上来就执行
    private fun loadConfig():String{
        println("loading...")
        return "hello world"
    }

}
// kotlin 的主构造函数
// 初始化顺序 代码是从上之下执行
//主构造函数里声明的属性
//类级别的属性赋值
//init初始化块里的属性赋值和函数调用
//次构造函数里的属性赋值和函数调用
//  lateinit var  延迟初始化
class Cat(
    _name:String,
    _age:Int,
    var sayHello:String
){
    var name = _name
    get() = field.capitalize()
    set(value) {
        field = value.trim()
    }
    var age = _age
    get() = age.absoluteValue
    set(value) {
        field =age.absoluteValue
    }

}
fun main(){
    var p = Player()
    p.name = " rose "
    println(p.name) // Rose
    var cat = Cat("小花狗",3,"hello")
    println("${cat.name}--${cat.sayHello}") // 小花狗--hello
    var s = Student("Jerry")
    Thread.sleep(3000)
    println(s.config) // loading...  hello world 3秒之后在执行

}