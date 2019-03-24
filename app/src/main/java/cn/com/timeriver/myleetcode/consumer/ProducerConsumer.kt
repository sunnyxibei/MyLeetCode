package cn.com.timeriver.myleetcode.consumer

import timber.log.Timber
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger


/**
 * 生产者/消费者模型
 *
 * 使用BlockQueue阻塞队列实现
 * 生产者是一堆线程，消费者是另一堆线程，内存缓冲区可以使用List数组队列，
 * 数据类型只需要定义一个简单的类就好。关键是如何处理多线程之间的协作。
 * 这其实也是多线程通信的一个范例。
 * 在这个模型中，最关键就是内存缓冲区为空的时候消费者必须等待，
 * 而内存缓冲区满的时候，生产者必须等待。
 * 其他时候可以是个动态平衡。
 * 值得注意的是多线程对临界区资源的操作时候必须保证在读写中只能存在一个线程，所以需要设计锁的策略。
 */

const val TAG = "ProducerConsumer"
const val SLEEP_MILL = 1000

data class Data(val data: Int)

class ProducerBlock(private var queue: BlockingQueue<Data>) : Runnable {

    companion object {
        var count: AtomicInteger = AtomicInteger()
    }

    @Volatile
    private var isRunning = true

    override fun run() {
        var data: Data
        val random = Random()
        Timber.tag(TAG).d("start producing id :%s", Thread.currentThread().id)
        try {
            while (isRunning) {
                data = Data(count.incrementAndGet())
                Timber.tag(TAG).d("$data 加入队列, 当前已经库存总数：${queue.size}")
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    Timber.tag(TAG).d(" 加入队列失败")
                }
                Thread.sleep(random.nextInt(SLEEP_MILL).toLong())
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
            isRunning = false
            Thread.currentThread().interrupt()
        }
    }

    fun stop() {
        isRunning = false
    }

}

class ConsumerBlock(private var queue: BlockingQueue<Data>) : Runnable {
    private val random = Random()
    override fun run() {
        Timber.tag(TAG).d("start Consumer id : ${Thread.currentThread().id}")
        while (true) {
            val data = queue.take()
            Timber.tag(TAG).d("$data 被消费, 当前剩余可消费数据个数 ${queue.size}")
            Thread.sleep(random.nextInt(SLEEP_MILL).toLong())
        }
    }

}

fun testBlock() {
    val queue = LinkedBlockingQueue<Data>()

    val producer1 = ProducerBlock(queue)
    val producer2 = ProducerBlock(queue)
    val producer3 = ProducerBlock(queue)

    val consumer1 = ConsumerBlock(queue)
    val consumer2 = ConsumerBlock(queue)
    val consumer3 = ConsumerBlock(queue)

    val threadPool = Executors.newCachedThreadPool()
    threadPool.execute(producer1)
    threadPool.execute(producer2)
    threadPool.execute(producer3)
    threadPool.execute(consumer1)
    threadPool.execute(consumer2)
    threadPool.execute(consumer3)

    threadPool.execute {
        Thread.sleep((10 * SLEEP_MILL).toLong())
        producer1.stop()
        producer2.stop()
        producer3.stop()

        Thread.sleep((5 * SLEEP_MILL).toLong())
        threadPool.shutdown()
    }
}