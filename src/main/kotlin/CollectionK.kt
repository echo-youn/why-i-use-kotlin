fun main() {
    val mutableList = mutableListOf(1,2,3)
    val immutableList = listOf(1,2,3)

    immutableList.plus(4)
    mutableList.add(4)
}
