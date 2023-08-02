fun main() {
    val user: User = User(1,"username")
    val user2: User2 = User2(2)
}

data class User(
    private val id: Long,
    private val username: String
)

data class User2(
    private val id: Long,
    private val username: String? = null
) {
    lateinit var a: String
}
