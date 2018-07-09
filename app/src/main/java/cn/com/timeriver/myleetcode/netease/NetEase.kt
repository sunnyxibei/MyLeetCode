package cn.com.timeriver.myleetcode.netease

/**
 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,
 * 但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,
 * 小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 * 输入描述: 输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。
 * 输出描述: 输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。
 * 输入例子1: 10
 */
fun getTheRightCoins(dst: Int): String {
    val builder = StringBuilder()
    var n = dst
    while (n >= 1) {
        if (n % 2 == 0) {
            n = (n - 2) / 2
            builder.append(2)
        } else {
            n = (n - 1) / 2
            builder.append(1)
        }
    }
    val reversed = builder.toString().reversed()
    println(reversed)
    return reversed
}


/**
 * 求“相反数”问题
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,
 * 之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,
 * 前缀零将会被忽略。例如n = 100, 颠倒之后是1.
 * 输入描述: 输入包括一个整数n,(1 ≤ n ≤ 10^5)
 * 输出描述: 输出一个整数,表示n的相反数
 */
fun getOppsiteNum(n: Int): Int {
    val nString = n.toString()
    val reversed = nString.reversed()
    return Integer.parseInt(reversed) + n
}

/**
 *  字符串碎片的平均长度
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 * 输入描述: 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 * 输出描述: 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 */
fun getFragmentLength(s: String): Int {
    var count = 0
    s.forEachIndexed { index, c ->
        if (index >= 1 && c != s[index - 1]) {
            count++
        }
    }
    return s.length / count
}