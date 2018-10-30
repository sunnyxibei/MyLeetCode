package cn.com.timeriver.pattern

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * 观察者模式的Kotlin实现
 */
interface Observable {

    fun registerObserver(observer: Observer)

    fun removeObserver(observer: Observer)

    fun notifyObserver()

}

interface Observer {

    fun onMessageReceive(message: String)

}

class RealObservable : Observable {

    private val mObservers = arrayListOf<Observer>()

    override fun registerObserver(observer: Observer) {
        mObservers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        mObservers.remove(observer)
    }

    override fun notifyObserver() {
        mObservers.forEach {
            it.onMessageReceive("Test Observer Design Pattern")
        }
    }
}

class RealObserver : Observer, AnkoLogger {

    override fun onMessageReceive(message: String) {
        info { message }
    }

}

object TestObserverDesignPattern {

    fun testMessage() {
        val observer = RealObserver()
        val observable = RealObservable()
        observable.registerObserver(observer)
        observable.notifyObserver()
        observable.removeObserver(observer)
        observable.notifyObserver()
    }

}