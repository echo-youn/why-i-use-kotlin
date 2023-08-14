fun main() {
    // 확장 메서드 정의 가능
    val a = "string"

    println(a.dummy())

    listOf("a", "b").getFirst()
}

fun String.dummy(): String {
    return "$this I am Dummy"
}

fun List<String>.getFirst(): String {
    return this[0]
}
