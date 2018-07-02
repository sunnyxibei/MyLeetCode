package cn.com.timeriver.myleetcode.other

object Test20 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
     *
     * @param numbers 输入的二维数组，二维数组必须是N*M的，否则分出错
     */
    fun printMatrixClockWisely(numbers: Array<IntArray>?) {
        // 输入的参数不能为空
        if (numbers == null) {
            return
        }
        // 记录一圈（环）的开始位置的行
        var x = 0
        // 记录一圈（环）的开始位置的列
        var y = 0
        // 对每一圈（环）进行处理，
        // 行号最大是(numbers.length-1)/2
        // 列号最大是(numbers[0].length-1)/2
        while (x * 2 < numbers.size && y * 2 < numbers[0].size) {
            printMatrixInCircle(numbers, x, y)
            // 指向下一个要处理的的环的第一个位置
            x++
            y++
        }
    }

    fun printMatrixInCircle(numbers: Array<IntArray>, x: Int, y: Int) {
        // 数组的行数
        val rows = numbers.size
        // 数组的列数
        val cols = numbers[0].size
        // 输出环的上面一行，包括最中的那个数字
        for (i in y..cols - y - 1) {
            print(numbers[x][i].toString() + " ")
        }
        // 环的高度至少为2才会输出右边的一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (rows - x - 1 > x) {
            // 因为右边那一列的最上面那一个已经被输出了，所以行呈从x+1开始，
            // 输出包括右边那列的最下面那个
            for (i in x + 1..rows - x - 1) {
                print(numbers[i][cols - y - 1].toString() + " ")
            }
        }
        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (rows - x - 1 > x && cols - 1 - y > y) {
            // 因为环的左下角的位置已经输出了，所以列号从cols-y-2开始
            for (i in cols - y - 2 downTo y) {
                print(numbers[rows - 1 - x][i].toString() + " ")
            }
        }
        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (cols - 1 - y > y && rows - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (i in rows - 1 - x - 1 downTo x + 1) {
                print(numbers[i][y].toString() + " ")
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val numbers = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(16, 17, 18, 19, 6), intArrayOf(15, 24, 25, 20, 7), intArrayOf(14, 23, 22, 21, 8), intArrayOf(13, 12, 11, 10, 9))
        printMatrixClockWisely(numbers)
        println()
        val numbers2 = arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), intArrayOf(22, 23, 24, 25, 26, 27, 28, 9), intArrayOf(21, 36, 37, 38, 39, 40, 29, 10), intArrayOf(20, 35, 34, 33, 32, 31, 30, 11), intArrayOf(19, 18, 17, 16, 15, 14, 13, 12))
        printMatrixClockWisely(numbers2)
        println()
        val numbers3 = arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8))
        printMatrixClockWisely(numbers3)
        println()
        val numbers4 = arrayOf(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), intArrayOf(16, 15, 14, 13, 12, 11, 10, 9))
        printMatrixClockWisely(numbers4)
        println()
        val numbers5 = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3), intArrayOf(4), intArrayOf(5), intArrayOf(6), intArrayOf(7), intArrayOf(8))
        printMatrixClockWisely(numbers5)
        println()
        val numbers6 = arrayOf(intArrayOf(0, 1), intArrayOf(15, 2), intArrayOf(14, 3), intArrayOf(13, 4), intArrayOf(12, 5), intArrayOf(11, 6), intArrayOf(10, 7), intArrayOf(9, 8))
        printMatrixClockWisely(numbers6)
        println()
        val numbers7 = arrayOf(intArrayOf(1, 2), intArrayOf(4, 3))
        printMatrixClockWisely(numbers7)
        println()
        val numbers8 = arrayOf(intArrayOf(1))
        printMatrixClockWisely(numbers8)
        println()
        // 0个元素的数组
        printMatrixClockWisely(arrayOf(intArrayOf()))
        // 空数组
        printMatrixClockWisely(null)
    }
}
