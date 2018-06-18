package cn.com.timeriver.myleetcode.string


object ValidPalindrome {
    /**
     * Valid Palindrome
     * 描述
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
     * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     */

    fun checkValidPalindrome(input: String): Boolean {
        val array = input.toCharArray()
        var left = 0
        var right = array.size - 1
        while (left < right) {
            if (!isAlphabet(array[left])) {
                left++
            } else if (!isAlphabet(array[right])) {
                right--
            } else if (!array[left].equals(array[right], true)) {
                return false
            } else {
                left++
                right--
            }
        }
        return true
    }

    private fun isAlphabet(ch: Char): Boolean {
        return ch in 'a'..'z' || ch in 'A'..'Z'
    }
}