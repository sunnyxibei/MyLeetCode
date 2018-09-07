package cn.com.timeriver.myleetcode

import cn.com.timeriver.myleetcode.other.GetMaxNum
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val array = intArrayOf(231, 24, 455, 46, 9, 1022)//9 46 455 24 231 1022
        val maxNumFromArray = GetMaxNum.getMaxNumFromArray(array)
        assertEquals(maxNumFromArray, 946455242311022)
    }
}
