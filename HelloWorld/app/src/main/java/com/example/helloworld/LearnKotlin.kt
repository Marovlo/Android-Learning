package com.example.helloworld

import kotlin.math.max

fun main(){
    val stu=student("a123",5,"zzl",21)
    val c1=cellphone("xiaomi",1200)
    val c2=cellphone("xiaomi",1200)
    println(c1==c2)
    var list= listOf("apple","pear","orange","grape","watermelon","berry")
    list=list.map { fruit:String->if(fruit.length>=5)fruit.uppercase()else fruit}
    for(fruit in list) println(fruit)

}
fun largerNumber(num1:Int,num2:Int) = max(num1,num2)

open class person(val name:String,val age:Int){//写在类名后面紧跟着的括号里面的函数是主构造函数，该函数没有函数体，只有赋值，如非要写一个函数体，请用init
    fun eat(time:String)= println("a person aged "+age+" named "+name+" is eating at "+time)
}

class student(val stuNO:String,val grade:Int,name: String,age: Int):person(name, age){//继承来的成员不写val或var,由父类决定,继承时必须调用父类的构造函数
    //可以是主构造函数也可以是次构造函数
    init {//强行给主构造函数写一个函数体
        eat("12:00")
        println("stuNo is "+stuNO)
        println("grade is "+grade)
    }
}

data class cellphone(val brand:String,val price:Int){

}