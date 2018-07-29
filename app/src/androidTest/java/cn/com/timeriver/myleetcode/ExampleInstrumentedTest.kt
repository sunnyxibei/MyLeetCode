package cn.com.timeriver.myleetcode

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import cn.com.timeriver.myleetcode.other.MopNum
import cn.com.timeriver.myleetcode.other.SimpleMopNum

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("cn.com.timeriver.myleetcode", appContext.packageName)
        MopNum(100000).printMopNum()
        SimpleMopNum(100000).printMopNum()
    }
}
