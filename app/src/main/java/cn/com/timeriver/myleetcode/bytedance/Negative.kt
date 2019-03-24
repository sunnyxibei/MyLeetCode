package cn.com.timeriver.myleetcode.bytedance

import timber.log.Timber

/**
 * 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，
 * 要求时间复杂度为O(n), 空间复杂度为O(1)。
 * 例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}
 * 变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
 *
 * 从数据结构的角度来讲
 * 第一种方式，一个单向链表存储数据
 */
object Negative {

    fun sortNegative() {
        val array = arrayOf(10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35)
        var pointer = 0
        if (array[pointer] < 0) {
            pointer++
        }
        array.forEachIndexed { index, i ->
            if (index > 0) {
                if (i < 0) {
                    //把pointer和index位置的值交换
                    val temp = array[pointer]
                    array[pointer] = i
                    array[index] = temp
                    pointer++
                }
            }
        }
        array.forEach {
            Timber.d(it.toString())
        }
    }

}