package com.fly.learn.algorithmV2.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2021/7/25
 * @Description:
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> output = new ArrayList<>();
        for(int num:nums){
            output.add(num);
        }
        int length = nums.length;
        dfs(length,output,result,0);
        return result;
    }

    /**
     *
     * @param length
     * @param output
     * @param result
     * @param first
     */
    private void dfs(int length,List<Integer> output,List<List<Integer>> result,int first){
        if(first == length){
            result.add(new ArrayList<>(output));
        }
        for(int i=first;i<length;i++){
            // 动态维护数组
            Collections.swap(output,first,i);
            dfs(length,output,result,first + 1);
            // 撤销操作
            Collections.swap(output,i,first);
        }
    }

}
