fun main() {
    println(ifIsExpression())

    println(bodyCanBeStatement())
}

fun ifIsExpression(): String {
    return if (true) {
        "true"
    } else {
        "false"
    }
}

fun bodyCanBeStatement(): String = if (true) "true" else "false"
