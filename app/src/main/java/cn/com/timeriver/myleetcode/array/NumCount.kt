package cn.com.timeriver.myleetcode.array

import timber.log.Timber

/**
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 * 主要在于数学规律的归纳
 * 详见：https://blog.csdn.net/yi_afly/article/details/52012593
 */
class NumCount {

    val TAG = this::class.java.simpleName

    fun printNumCount(n: Int) {
        Timber.tag(TAG).d("从0到 $n 中1出现了 ${countNum(n)} 次")
    }

    private fun countNum(n: Int): Int {
        if (n == 1) return 0
        var count = 0
        var base = 1
        var num = n
        while (num > 0) {
            val weight = num % 10
            num /= 10
            count += num * base
            if (weight == 1) {
                //余数是1的情况
                count += n % base + 1
            } else if (weight > 1) {
                count += base
            }
            base *= 10
        }
        return count
    }
}