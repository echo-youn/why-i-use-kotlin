fun main(args: Array<String>) {
    // Any, Any?
    var a: String? = nullableFunction(args.isEmpty())

    // Null 체크하는 API 제공
    if (a.isNullOrEmpty()) {
        println("this is null or empty a: $a")
        a = "Not null" // null이 체크가 된다면 컴파일러가 null safty를 확실하게 검증해준다.
    }

    a = nullableFunction(args.isNotEmpty())

    if (a == null) {
        println("a is null")
    }







    // elvis 연산자
    val b = a ?: "A is Null I Executed"
    val e = a?.chars()
        ?.also {
            println(it)
        }
        ?.toString()?.toString() ?: {
        println("a is null")

        throw Exception()
    }
    println(b)

    // in java
    var c: String
    if (a == null) {
        c = "A is Null"
    } else {
        c = a
    }
}

fun nullableFunction(isNull: Boolean): String? {
    return if (isNull) {
        null
    } else {
        "not null"
    }
}
