package cn.com.timeriver.myleetcode

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import cn.com.timeriver.myleetcode.consumer.testBlock
import cn.com.timeriver.pattern.TestObserverDesignPattern
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

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
        TestObserverDesignPattern.testMessage()

        // Negative.sortNegative()
        // SetPart.testPart()
        testBlock()
    }
}
