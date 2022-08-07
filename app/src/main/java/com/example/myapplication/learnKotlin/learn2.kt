package com.example.myapplication.learnKotlin

fun main() {
    // 调用成员方法 需要先构建对象
    Person().test()
    // 调用半生类方法
    Person.test2()
    // 调用静态方法
    val res = Utils.double(5)
    println("静态方法：$res")
    // 调用默认参数 默认参数如果在前，需要指定无默认参数的参数
    read(b = 2);
    // 也可以传递数据进行调用
    read(10, 20)
    // 调用传入方法的参数
    read2(1, 2, action = {
        "我是括号内传递的方法"
    })
    // 在括号外调用
    read2(1, 2) {
        "我是括号外调用的方法"
    }
    //可变参数的要求：
    //只有一个参数可以标注为vararg;
    // 1. 如果 vararg 参数不是最后一个参数，可以使用具名参数语法，给后面的参数的传递值，
    append("h", "e", "l", "l", "o", num = 10)
}

// 普通类
class Person() {
    // 在普通类中声明成员方法
    fun test() {
        println("成员方法")
    }

    // 伴生类 不需要构建实例对象
    companion object {
        fun test2() {
            println("伴生类方法")
        }
    }
}

// 默认参数
fun read(a: Int = 1, b: Int) {
    println("$a---$b")
}

//传递的数据有方法
fun read2(a: Int = 0, b: Int, action: () -> String) {
    // 调用方法
    val res = action()
    println("$a -- $b -- $res")
}

// 可变参数方法
fun append(vararg string: String, num: Int) {
    val res = string.forEach { item ->
        "$item-"
    }
    println("$res$num")
}

// 静态类
object Utils {
    fun double(num: Int): Int {
        return num * 2
    }
}