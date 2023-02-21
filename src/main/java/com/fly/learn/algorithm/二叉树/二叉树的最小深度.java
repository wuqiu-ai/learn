package com.fly.learn.algorithm.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: peijiepang
 * @date 2021/7/27
 * @Description:
 */
public class 二叉树的最小深度 {

    class QueueNode{
        TreeNode node;
        int height;
        public QueueNode(TreeNode node,int height){
            this.node = node;
            this.height = height;
        }
    }

    /**
     * 层次遍历计算每个node的dept
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        Queue<QueueNode> queueNodes = new LinkedList<>();
        queueNodes.offer(new QueueNode(root,1));
        while (!queueNodes.isEmpty()){
            QueueNode queueNode = queueNodes.poll();
            TreeNode treeNode = queueNode.node;
            if(treeNode.left == null && treeNode.right == null){
                return queueNode.height;
            }
            if(null != treeNode.left){
                queueNodes.offer(new QueueNode(treeNode.left,queueNode.height +1 ));
            }
            if(null != treeNode.right){
                queueNodes.offer(new QueueNode(treeNode.right,queueNode.height + 1));
            }
        }
        return 0;
    }

}
