fun main() {
    // 코틀린은 Immutable Collection을 지향한다.
    // 불변컬렉션과 가변컬렉션을 정확하게 구분한다.
    val mutableList = mutableListOf(1,2,3,5,6)
    val immutableList = listOf(1,2,3,7,8,9)

    immutableList.plus(4)
    mutableList.add(4)

    // 다양하고 강력한 내장 라이브러리를 제공합니다.
    mutableList.minus(immutableList)
//    mutableList.minusAssign(immutableList)
    println(immutableList.minus(mutableList))

    val s = immutableList.union(mutableList)
    println(s)


    val a = StringBuilder().apply {
        append(1)
        append(2)

        append(1,2,3,4,5)
    }

    println(a)
}
