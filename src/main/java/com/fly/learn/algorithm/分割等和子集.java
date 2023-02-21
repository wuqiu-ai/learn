package com.fly.learn.algorithm;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2020/10/11
 * @Description:
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 数组长度小于2
        if(n < 2){
            return false;
        }
        int sum=0,maxNum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            maxNum = Math.max(maxNum,nums[i]);
        }
        // 不能整除说明不能2个子集相加
        if(sum % 2 != 0){
            return false;
        }
        int target = sum /2;
        // 最大的值大于目标值
        if(maxNum > target){
            return false;
        }
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0;i<n;i++){
            int num = nums[i];
            for(int j=target;j>=num;j--){
                dp[j] |= dp[j-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        分割等和子集 test = new 分割等和子集();
        int[] nums = new int[]{1, 5, 11, 5};
        test.canPartition(nums);
    }

}
