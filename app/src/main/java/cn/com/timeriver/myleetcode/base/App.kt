package cn.com.timeriver.myleetcode.base

import android.app.Application
import cn.com.timeriver.myleetcode.BuildConfig
import timber.log.Timber

class App : Application() {

    companion object {
        private lateinit var sInstance: App
        fun getInstance() = sInstance
    }

    override fun onCreate() {
        super.onCreate()

        sInstance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(FileLoggingTree())
        }

    }

}