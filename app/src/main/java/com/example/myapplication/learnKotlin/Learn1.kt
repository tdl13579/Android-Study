package com.example.myapplication.learnKotlin

import org.json.JSONObject

fun main() {
    /**
     *什么是位宽（bit),计算机中最新数据存储单位，1个字节=8位
     *1.在计算当中，所有数字（1,2,3,4int,long,byte)在存储的时候，都是二进制存储
     *2.二进制8位称为1个字节
     *3.int数据类型是占了4个字节=4*8=32位
     *4.long数据类型占了8个字节=8*8=64位
     *
     *举例：int类型的10==0000.省略了20个0..00001010I
     *举例：int类型的2,147,483,647==01111111111...1111
     */
    val num = 100 // 默认是Int
    val bigNumber = 1012345678 // 自动推断位Long
    val byteNumber: Byte = 1
    val floatNumber = 3.14159268888f
    var doubleNumber = 3.14159268888
    println("floatNumber:$floatNumber,doubleNumber:$doubleNumber") // floatNumber:3.1415927,doubleNumber:3.14159268888
    val char: Char = '0' // 字符类型 用单引号修饰
    var str = "hello world"
    println("str:$str----${str.length}") //hello world----11  \n 换行  \ 转义符 “”“ ”“” 分界符 字符串无须转义
    var str2 = """
        hello world ！
        你好 世界！
    """.trimIndent() // trimIndent去除所有空格 trimMargin 去除前后空格
    println("str2:$str2----${str2.length}") // 20
    // 数据容器 数组，集合
    // 数组 arrayOf创建数组，必须指定元素，可以是任意类型
    val ArrayNumber = arrayOf(1, 2, 3, 4, 5)
    val ArrayNumber2 = arrayOf(1, true, "str")
    // 创建一个空数组，指定长度
    val arr = arrayOfNulls<String>(5)
    for (item in ArrayNumber) {
        println(item)
    }
    println("----------------")
    for (i in ArrayNumber.indices) {
        println(i.toString() + "-->" + ArrayNumber[i])
    }
    println("----------------")
    for ((i,item) in ArrayNumber.withIndex()) {
        println(i.toString() + "-->" +item)
    }
    ArrayNumber.forEach{
        println("$it--> forEach")
    }

}
