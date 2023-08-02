fun main() {
    val a = "string"

    println(a.dummy())
}

fun String.dummy(): String {
    return "$this I am Dummy"
}
