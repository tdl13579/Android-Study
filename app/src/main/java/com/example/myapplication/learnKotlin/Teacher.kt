package com.example.myapplication.learnKotlin

open class Teacher(val name:String) {
    fun desc() = "teacher： 我是老师"
    open fun say() = "hello $name"
}
class OtherTeacher: Teacher("jack"){
    // override 这个关键字重写父类的方法 同时要父类用到open关键字
    override fun say() = "student hello $name"
    fun play() = "I like play"
    // 伴生类  初始化数据
    companion object{
        private const val HELLO = "hello"
        fun initHello() = "init $HELLO"
    }
}
object ApplicationConfig{
    init {
        println("loading")
    }
    fun doSomeThing() = "doSomeThing"
}
fun main(){
    val otherTeacher:Teacher = OtherTeacher()
    println(otherTeacher.say()) // student hello jack
    // 用is来进行类型检测 Any是所有类的超类
    println(otherTeacher is OtherTeacher) // true
    println(otherTeacher is Teacher) // true
    println(otherTeacher is Any) // true
    // 可以用as来做类型转换
    if(otherTeacher is OtherTeacher){
        println((otherTeacher as OtherTeacher).play()) // I like play
    }
    println(ApplicationConfig.doSomeThing()) // loading doSomeThing
//    ApplicationConfig 是类名 也是实例
}
// 伴生对象
