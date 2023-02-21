package com.fly.learn.algorithm.贪心法;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2020/12/17
 * @Description:
 */
public class 单调递增的数字 {

    /**
     * 贪心法
     * 1. 针对前面本来就是递增的，直接按照递增处理
     * 2. 从不递增开始，每个数值直接为最大值9，前一位必须减1
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int i = 1;
        // 递增部分
        while (i < chars.length && chars[i-1] <= chars[i]){
            i++;
        }
        if(i < chars.length){
            while ( i >0 && chars[i] < chars[i-1]){
                chars[i-1]--;
                i--;
            }
            for(i=i+1;i<chars.length;i++){
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        单调递增的数字 test = new 单调递增的数字();
        test.monotoneIncreasingDigits(332);
    }

}
