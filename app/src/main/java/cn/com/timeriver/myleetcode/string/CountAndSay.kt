package cn.com.timeriver.myleetcode.string

/**
 * Count and Say
 *
 * 描述
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2", then "one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
object CountAndSay {

    fun getSequence(n: Int): String {
        if (n <= 0) {
            return ""
        }
        val builder = StringBuilder()
        var string = "1"
        for (x in 1 until n) {
            var count = 0
            var lastChar = string[0]
            for (i in string.indices) {
                if (string[i] == lastChar) {
                    count++
                } else {
                    builder.append(count).append(lastChar)
                    count = 1
                    lastChar = string[i]
                }
            }
            builder.append(count).append(lastChar)
            string = builder.toString()
            builder.setLength(0)
        }
        return string
    }
}