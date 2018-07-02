package cn.com.timeriver.myleetcode.other

import timber.log.Timber

/**
 * 顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次扫印出每一个数字
 */
object MatrixPrinter {

    const val TAG = "MatrixPrinter"

    private val matrix: Array<IntArray> = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(16, 17, 18, 19, 6),
            intArrayOf(15, 24, 25, 20, 7),
            intArrayOf(14, 23, 22, 21, 8),
            intArrayOf(13, 12, 11, 10, 9))

    fun printMatrixClockWisely() {
        //首先得到矩阵的行数和列数
        var lineNum = matrix.size
        var columnNum = 0
        matrix.forEach { if (it.size > columnNum) columnNum = it.size }

        //首先打印第一行
        var i = 0 //当前循环到的行数
        var j = 0 //当前循环到的列数
//        while (i < lineNum) {

        //打印第一行
        while (j < columnNum) {
            Timber.tag(TAG).d("${matrix[i][j]}")
            j++
        }
        lineNum--

        //打印最后一列
        if (j == columnNum) {
            while (i < lineNum) {
                Timber.tag(TAG).d("${matrix[++i][j - 1]}")
            }
        }
        columnNum--

        //打印最下面一行
        if (i == lineNum) {
            while (j > 0) {
                Timber.tag(TAG).d("${matrix[i - 1][--j]}")
            }
        }
        lineNum--

        //打印第一列
        if (j == 1) {
            while (--i > 1) {
                Timber.tag(TAG).d("${matrix[i][j - 1]}")
            }
        }
        columnNum--

        //然后，递归调用
//        }

    }


}