fun main() {
    val a: String? = null

    if (a.isNullOrEmpty()) {
        println("this is null or empty")
    }

    // elvis 연산자
    val b = a ?: "A is Null"
    println(b)

    // in java
    var c: String;
    if (a == null) {
        c = "A is Null";
    } else {
        c = a;
    }
}
