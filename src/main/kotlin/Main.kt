fun main(args: Array<String>) {
    println("Hello World!")

    println(ifIsExpression(args.isEmpty()))
}

// 코틀린에서는 If는 Statement가 아니라 Expression 입니다.
fun ifIsExpression(param: Boolean): String {
    param
    return if (param) {
        "true"
    } else {
        "false"
    }
}
