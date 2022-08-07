package com.example.myapplication.learnKotlin

import java.io.File
import kotlin.math.roundToInt

fun main(){
    println(9.145.toInt()) // 9
    println(9.745.roundToInt()) // 10
    // double类型格式化
    var str = "%.2f".format(9.738153)
    println(str) // 9.74 (保留两位小数)
    //    apply 返回当前接受者，let 最后一行为返回值 。run函数 最后一行为返回值 (::函数名) :: 双冒号调用
    //  with 函数和run差不多，只是传参方式不一样  also函数 返回接受者对象
    // takeIf 函数  根据传入内容判断为真时，返回为接受者对象，不然就是null
    // takeUnless 根据传入内容判断为假时，返回接受者对象，不然就是null 和 takeIf 相反

    var bool = "i have a dream".run {
        length > 10
    }
    println(bool)
    var res = "what is you name".run {
        this.length > 10
    }
    var res1 = with("what is you name"){
        length > 10
    }
    println("$res---$res1")
    var res2 = "I hava a dream".takeIf { "test".length > 3 }.apply { this?.length }
    println("$res---$res1 -- $res2")
    var res3 = "I hava a dream".takeUnless { "test".length > 3 }.apply { this?.length }
    println("$res---$res1 -- $res2 -- $res3") // true---true -- I hava a dream -- null
}