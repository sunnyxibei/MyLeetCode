package cn.com.timeriver.myleetcode.base

import android.os.Environment
import timber.log.Timber
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

/**
 * Timber Log Tree
 */
class FileLoggingTree : Timber.Tree() {

    private val _CACHE_DIR: String =
            Environment.getExternalStorageDirectory().absolutePath + "/log.txt"

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        val file = File(_CACHE_DIR)
        var bufferedWriter: BufferedWriter? = null
        try {
            bufferedWriter = BufferedWriter(FileWriter(file))
            bufferedWriter.write(message)
            bufferedWriter.flush()

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bufferedWriter?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}
