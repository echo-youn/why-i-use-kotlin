fun main(args: Array<String>?) {
    // 람다를 사용해 가독성을 높일 수 있다.

    args
        ?.let {
            args.plus(listOf("1", "2"))
        }
        ?.map { "$it + mapped" }
        ?.map(mapFunction)
        ?.run {
            println(this)
        } ?: println("args is null")
}

val mapFunction: (String) -> String = {
    "$it + map Function"
}
