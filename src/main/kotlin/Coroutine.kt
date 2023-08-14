import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

fun now(): String = LocalDateTime.now().toString()

// name, priority, thread group
private fun log(msg: String) = println("${now()}: [${Thread.currentThread()}]: $msg")

fun main() {
    log("Main function start!")
//    Thread(SimpleThread("runBlocking")).start()
//    Thread(SimpleThread("launch")).start()
//    Thread(SimpleThread("async")).start()
}

class SimpleThread(
    private val type: String
) : Runnable {
    override fun run()  {
        log("+++++++++++ Welcome to non-suspend world +++++++++++")
        when (type) {
            "runBlocking" -> {
                runBlocking {
                    log("--------------- Welcome to suspend world ---------------")
                    delay(5_000)
                    log("--------------- Goodbye suspend world ---------------")
                }
            }

            "launch" -> {
                runBlocking {
                    log("--------------- Welcome to suspend world ---------------")
                    delayWithLaunch("1", 1000, this)
                    delayWithLaunch("5", 5000, this)
                    delayWithLaunch("2", 2000, this)
                    delayWithLaunch("3", 3000, this)
                    delayWithLaunch("6", 6000, this)
                    delayWithLaunch("3", 4000, this)

                    // Dispatcher
                    launch {
                        delay(7000)
                        log("7")
                    }
                    log("--------------- Goodbye suspend world ---------------")
                }
            }

            "async" -> {
                runBlocking {
                    log("--------------- Welcome to suspend world ---------------")
                    val a = delayWithAsync("1", 1000, this)
                    val b = delayWithAsync("2", 2000, this)
                    val c = delayWithAsync("3", 3000, this)
                    val d = delayWithAsync("5", 5000, this)
                    val e = delayWithAsync("4", 4000, this)
                    val f = delayWithAsync("6", 6000, this)

                    val g = async {
                        delay(7000)
                        log("7")
                        7000L
                    }

                    listOf(
                        a.await(),
                        b.await(),
                        c.await(),
                        d.await(),
                        e.await(),
                        f.await(),
                        g.await()
                    ).sum()
                        .also {
                            log("Total latency was $it")
                        }
                    log("--------------- Goodbye suspend world ---------------")
                }
            }
        }
        log("+++++++++++ Goodbye non-suspend world +++++++++++")
    }
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun delayWithLaunch(msg: String, latency: Long, scope: CoroutineScope) = scope.launch {
    delay(latency)
    log(msg)
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun delayWithAsync(msg: String, latency: Long, scope: CoroutineScope) = scope.async {
    delay(latency)
    log(msg)
    latency
}
