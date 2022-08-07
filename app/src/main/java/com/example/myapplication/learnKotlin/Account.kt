package com.example.myapplication.learnKotlin

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

// 这种声明方式可以不需要附初始值
data class private constructor(val uid: String, val userName: String, val passWord: String)

class Account {
    val uid: String = "00001"
    val userName: String = "jerry"
    val passWord: String = "123456"
    override fun toString(): String {
        return "Account(uid='$uid', userName='$userName', passWord='$passWord')"
    }

}

lateinit var str :String //
val s1 :String by lazy { "by lazy string" }
const val name = "jerry"

fun more(vararg a:Int) : Int{ // vararg 可以传递多个值
    println(a.get(0)+a.get(1))
   return a.get(0)+a.get(1)
}



fun main() {
    more(1,2)
    // java对象和JSON对象的相互转换
    // 转化为Json
    val accountString: String = Gson().toJson(Account());
    println("JSON:$accountString") //JSON:{"uid":"00001","userName":"jerry","passWord":"123456"}
    // 转化为对象
    val account: Account = Gson().fromJson(accountString, Account::class.java)
    val acount = account.toString()
    println("Account对象：${acount}") //Account对象：Account(uid='00001', userName='jerry', passWord='123456')
    // 集合和JSON对象的相互转换
    val accountList = "[{\"uid\":\"00001\",\"userName\":\"jerry\",\"passWord\":\"123456\"}]"
    // 转换为集合
    val acountList: List<Account> =
        Gson().fromJson(accountList, object : TypeToken<List<Account>>() {}.type)
    println("json 集合：$accountList") // json 集合：[{"uid":"00001","userName":"jerry","passWord":"123456"}]
    // 集合转换为json
    val acountJsonList = Gson().toJson(accountList)
    println("toJson集合：$acountJsonList") // toJson集合："[{\"uid\":\"00001\",\"userName\":\"jerry\",\"passWord\":\"123456\"}]"
}
