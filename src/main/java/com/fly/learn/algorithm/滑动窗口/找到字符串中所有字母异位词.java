package com.fly.learn.algorithm.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2020/7/27
 * @Description:
 */
public class 找到字符串中所有字母异位词 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 滑动窗口
        int[] windows = new int[128];
        // 必须出现的字符
        int[] needs = new int[128];

        for(int i=0;i<p.length();i++){
            needs[p.charAt(i)]++;
        }

        // 左右指针
        int left = 0;
        int right = 0;

        while (right<s.length()){
            // 将右窗口当前访问到的元素 curR 个数加 1
            windows[s.charAt(right)]++;

            while (windows[s.charAt(right)] > needs[s.charAt(right)]){
                // 将左窗口当前访问到的元素 curL 个数减 1
                windows[s.charAt(left)]--;
                left++;
            }

            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if((right-left+1) == p.length()){
                res.add(left);
            }

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s,p);
    }

}
