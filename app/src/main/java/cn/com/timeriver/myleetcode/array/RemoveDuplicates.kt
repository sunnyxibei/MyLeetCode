package cn.com.timeriver.myleetcode.array

import timber.log.Timber


/**
 * Remove Duplicates from Sorted Array
 * 描述
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
fun removeDuplicates(intArray: IntArray) {

    //Java中数组是不可变的，所以记录下新数组的长度后，返回的是新数组的[0,length)的数字
    if (!intArray.isEmpty()) {
        var index = 1
        for (i in 1 until intArray.size) {
            if (intArray[i] != intArray[i - 1]) {
                intArray[index] = intArray[i]
                index++
            }
        }
        Timber.tag("Remove Duplicates ").d(index.toString())

        val build = StringBuilder()
        for (i in 0 until index) {
            build.append(intArray[i]).append(",")
        }
        Timber.tag("Remove Duplicates ").d(build.toString())
    }

}