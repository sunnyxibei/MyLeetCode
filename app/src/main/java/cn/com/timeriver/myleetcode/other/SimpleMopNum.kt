package cn.com.timeriver.myleetcode.other

import timber.log.Timber

/**
 * 求自然数n内所有猫扑素数
 * 猫扑数：指以2开头，后面跟任意个3的十进制数。如：2、23、233等。
 *
 * 素数（质数）：在大于1的自然数中，除了1和它本身以外不再有其他因数，这样的数称为素(质)数。
 *
 * 合数：自然数中除能被1和本数整除外，还能被其他的数整除的数。如果一个数是合数，那么它的最小质因数肯定小于等于他的平方根。例如：50，最小质因数是2，2<50的开根号，
 * 再比如：15，最小质因数是3，3<15的开根号。。
 *
 * 1和0既非素数也非合数。
 */
class SimpleMopNum(var n: Int) {

    val TAG = this::class.java.simpleName

    /**
     * 简单解法
     * 1、根据MopNum的规则特征生产MopNum
     * 2、判断是否是素数
     */
    fun printMopNum() {
        if (n < 2) {
            return
        } else {
            generateAndCheckMopNum()
        }
    }

    private fun generateAndCheckMopNum() {
        var num = 2
        Timber.tag(TAG).d(num.toString())
        while (true) {
            num = num * 10 + 3
            if (num > n) return
            if (isPrime(num)) {
                Timber.tag(TAG).d(num.toString())
            }
        }
    }

    private fun isPrime(i: Int): Boolean {
        var flag = true
        if (i < 2) flag = false
        for (j in 2..Math.sqrt(i.toDouble()).toInt()) {
            if (i % j == 0) {
                flag = false
                break
            }
        }
        return flag
    }
}