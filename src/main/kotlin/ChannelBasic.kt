import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

// name, priority, thread group
private fun log(msg: String) = println("${now()}: [${Thread.currentThread()}]: $msg")
var i = 0

fun main(args: Array<String>) = runBlocking {
    val channel = Channel<Int>(20)
    dataProducer(channel)

    repeat(5) {
        launchProcessor(it, channel)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (i in channel) {
        log("#$id number: $i")
        delay((Math.random() * 100).toLong()) // 속도 조절
    }
}

fun CoroutineScope.dataProducer(channel: SendChannel<Int>) = launch {
    repeat(100) {
        channel.send(i++)

        delay(10)
    }

    channel.close() // channel을 닫아줘야 processor(Consumer)가 더이상 대기하지 않는다.
}
