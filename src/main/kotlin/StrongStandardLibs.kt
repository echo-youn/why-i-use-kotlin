fun main() {
    val list = listOf(1,2,3)
    val list2 = listOf(2,3,4)

    val result = list.subtract(list2)

    println(result)

    val a = StringBuilder().apply {
        append(1)
        append(2)
        append(1,2)
    }
}
