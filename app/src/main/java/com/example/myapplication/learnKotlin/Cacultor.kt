package com.example.myapplication.learnKotlin

fun main() {
    while (true) {
        println("=====请输入表达式=====")
        val input: String? = readLine() // 数字转化为文本
        try {
            input?.let {
                val res = caculate(it)
                println("$it = $res")
                println("是否继续使用(y/n)")
                val cmd = readLine()
                cmd?.let {
                    if (it == "n") {
                        System.exit(-1)
                    } else {

                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun caculate(input: String?): String {
    if (input?.contains("+") == true) {
        var nums = input?.trim()?.split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "+").toString()
    } else if (input?.contains("-") == true) {
        var nums = input?.trim()?.split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "-").toString()
    } else if (input?.contains("*") == true) {
        var nums = input?.trim()?.split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "*").toString()
    } else if (input?.contains("/") == true) {
        var nums = input?.trim()?.split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "/").toString()
    } else {
        return "输入的表达式有误"
    }
}

fun operate(a: Double, b: Double, operate: String): Double {
    return when (operate) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> 0.0
    }
}