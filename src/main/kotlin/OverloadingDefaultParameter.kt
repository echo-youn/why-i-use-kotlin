fun main() {
    // 회의시간에 나온 secondary constructor 해결 가능
    val c = MyComplexClass("private", 1, 1)

//    println(c.setMemberProperty())
//    println(c.getMemberProperty())

    println(c)




    simpleMethod(d = false)
    simpleMethod(d = true, c = 7777)
}


// 프로퍼티 선언 data class, class 차이
class MyComplexClass(
    private val privateProperty: String,
    val readOnlyProperty: Int,
    var reAssignableProperty: Int,
    val optionalProperty: String = "",
    val nullableProperty: String? = null,
    constructorParameter: String? = null // value-parameter, 생성자에서 사용하는 매개변수일뿐..
) {
    lateinit var memberProperty: String

    fun doSomething1() {
        reAssignableProperty = 1
    }

    fun setMemberProperty() {
        memberProperty = "value"
    }

    fun getMemberProperty() {
        println(memberProperty)
    }

    // 생성자 생성 가능
    constructor() : this("", 1, 1)
}

fun simpleMethod(
    a: String = "a",
    b: String = "b",
    c: Int = 1,
    d: Boolean
) {
    println("$a $b $c $d")
    return
}
