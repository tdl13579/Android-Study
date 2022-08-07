package com.example.myapplication.learnKotlin

import kotlin.math.roundToInt

// 匿名函数 就是lambda 表达式
fun main() {
    val myFun: (Int, Int, Int) -> String = { num1, num2, num3 ->
        val value = "jerry"
        "$value 参数一: $num1, 参数一: $num2, 参数一: $num3" // 最后一行是隐式返回，不需要写return
    }
    println(myFun(1, 2, 3))
    val myFun2: (String) -> String = { "$it jerry" } // 如果只有一个参数 #it 就是代表那个参数
    println(myFun2("hello"))
    // 匿名函数会默认推断放回结果，直接用等号的方式书写
    val myFun3 = { name: String, age: Int ->
        name + age
    }
    println(myFun3("jerry", 18))
    // 声明name 是可以为空的 默认是不能为空的 避免出现空指针异常
    var name: String? = null;
    name = "jerry"
    var newName = name?.let { // let 方法 如果name 为空 let方法就不会执行
        if (it.isBlank()) { // isBlank判断是否为空 如果name 为空值 “” 空值
            "Default"
        } else {
            "$it 不是空值"
        }
    }
    println(newName)
    var a: String? = null
//    var newA = a!!.capitalize() // !! 不管是不是空都执行  只有保证a一定不是空值 才会使用!! 不然会出现空指针异常
    // 空合并操作符 xxx ?: "为空执行"  --> 如果 xxx为null  就会执行后面对的代码输出 “为空执行”
    try {
        var info: String? = null
        checkException(info)
        println(info!!.length)  // 如果info为空，就会报空指正异常，!! 不管是否为空都会执行
    } catch (e: Exception) {
        println("$e")
    }
    var value: String? = null
    var value2: Boolean = false
//    checkNotNull(value) // 如果value  为空就会抛出异常
//    requireNotNull(value)
//    require(value2) // 用来判断boolean 的对错 为FALSE 会抛出异常
    val INFO: String = "jerry -is the best boy"
    val indexof = INFO.indexOf("i") // 获取i的下标
    println(INFO.substring(0, indexof))
    println(INFO.substring(0 until indexof)) // 与上面是等价的
    var names = "andy,lucy,tina,mike"
    var list = names.split(",")
    println(names.split(",")+"----")
    println(list+"----")
    // 结构
    var (v1,v2,v3,v4) = list
    println("v1:$v1,v2:$v2,v3:$v3,v4:$v4")
    // replace 替换数据
    println(INFO.replace("jerry","tan"))
    // 格式转换 toInt()
    println(561.15.toInt()) //561 转化为int
    println(561.65.roundToInt()) // 562
    // info.apply函数 始终返回 info 本身  apply 里面会有一个this
    // let 函数 匿名函数有一个it 代码 他的本身内容 根据最后一行内容变化，返回值而变化  匿名函数一般会有一个it
    // run 函数里面是有一个this 根据最后一行内容返回值而变化
    val lists = listOf(5,2,4,2)
    println(lists.first()) // 返回第一个元素 5
    var res = lists.let {
        it.first() + it.last()
    }
    println(res) // 5 + 2 = 7


}

fun checkException(info: String?) {
    info ?: throw CustomExpection() //如果是null 就会抛出异常
}

class CustomExpection : IllegalAccessException("代码不严谨")
