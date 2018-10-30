package cn.com.timeriver.myleetcode.other

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.atomic.AtomicInteger

/**
 * 生产者消费者模型的kotlin实现
 * 一个经典的缓存处理策略，经常在后端任务中使用
 * 其实RxJava的BackPressure也是类似的思想
 */
object ProducerConsumer : AnkoLogger {

    const val DELAY = 1000L

    private val count = AtomicInteger()

    /**
     * 开始生产和消费，入口方法
     */
    fun startWork() {
        val queue = LinkedBlockingDeque<Hamburger>()

        val producer1 = Producer(queue)
        val producer2 = Producer(queue)
        val producer3 = Producer(queue)
        val producer4 = Producer(queue)

        val consumer1 = Consumer(queue)
        val consumer2 = Consumer(queue)
        val consumer3 = Consumer(queue)
        val consumer4 = Consumer(queue)

        val service = Executors.newCachedThreadPool()
        service.execute(producer1)
        service.execute(producer2)
        service.execute(producer3)
        service.execute(producer4)
        service.execute(consumer1)
        service.execute(consumer2)
        service.execute(consumer3)
        service.execute(consumer4)

        Thread.sleep(20 * DELAY)
        producer1.stop()
        producer2.stop()
        producer3.stop()
        producer4.stop()
        Thread.sleep(3000)
        service.shutdown()
    }

    /**
     * 生产者
     */
    class Producer(private val queue: BlockingQueue<Hamburger>) : Runnable {

        override fun run() {
            try {
                while (!Thread.interrupted()) {
                    Thread.sleep(DELAY)
                    val get = count.incrementAndGet()
                    info { "$this 开始生产第 $get 个Hamburger" }
                    val hamburger = Hamburger(get)
                    queue.offer(hamburger)
                    info { "第 $get 个Hamburger加入缓存队列" }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
                Thread.currentThread().interrupt()
            }
        }

        fun stop() {
            Thread.currentThread().interrupt()
        }

    }

    /**
     * 消费者
     */
    class Consumer(private val queue: BlockingQueue<Hamburger>) : Runnable {

        override fun run() {
            while (true) {
                try {
                    val take = queue.take()
                    info { "$this 消费了Hamburger -> ${take.price}" }
                    Thread.sleep(DELAY)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    Thread.currentThread().interrupt()
                }
            }
        }
    }

    data class Hamburger(val price: Int)

}
