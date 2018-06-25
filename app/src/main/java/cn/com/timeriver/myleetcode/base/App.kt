package cn.com.timeriver.myleetcode.base

import android.app.Application
import cn.com.timeriver.myleetcode.BuildConfig
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(FileLoggingTree())
        }

    }

}