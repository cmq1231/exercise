package com.quiz.chat3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 执行二叉树的中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root){
        // 创建用于存储遍历结果的列表
        List<Integer> result = new ArrayList<>();
        // 调用递归遍历函数，从根节点开始
        traversal(root,result);
        return  result;

    }

    /**
     * 中序遍历顺序：左子树 -> 根节点 -> 右子树
     * @param node
     * @param result
     */
    public static void traversal(TreeNode node,List<Integer> result){
        if(node==null){
            return;
        }
        // 1. 递归遍历左子树（处理左子节点）
        traversal(node.left,result);
        // 2. 访问当前节点（根节点），将值添加到结果列表
        result.add(node.data);
        // 3. 递归遍历右子树（处理右子节点）
        traversal(node.right,result );
    }
    public static  void  main(String args[]){
        // 构建二叉搜索树：
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 执行中序遍历
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }
}
