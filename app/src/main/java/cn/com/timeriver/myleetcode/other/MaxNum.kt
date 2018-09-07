package cn.com.timeriver.myleetcode.other

/**
 * 设有n个正整数，将它们连成一排组成一个整数，请输出其中最大的结果。
 */
object GetMaxNum {

    /**
     * 逻辑分析
     * 本质上是使用一种规律对已知的数组做一个排序
     *
     * 规则抽象：
     * a+b > b+a 则ab交换
     *
     * 排序算法：
     * 都可以，这里用选择排序做一个示例
     */
    fun getMaxNumFromArray(array: IntArray): Long {
        for (i in 0 until array.size) {
            for (j in i until array.size) {
                if (compareNum(array[j], array[i])) {
                    swap(array, i, j)
                }
            }
        }
        val builder = StringBuilder()
        array.forEach {
            builder.append(it.toString())
        }
        return builder.toString().toLong()
    }

    private fun compareNum(a: Int, b: Int): Boolean {
        val aString = a.toString()
        val bString = b.toString()
        return (aString + bString).toInt() > (bString + aString).toInt()
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}