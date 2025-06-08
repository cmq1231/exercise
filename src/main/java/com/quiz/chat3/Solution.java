package com.quiz.chat3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return  result;

    }

    public static void traversal(TreeNode node,List<Integer> result){
        if(node==null){
            return;
        }
        traversal(node.left,result);
        result.add(node.data);
        traversal(node.right,result );
    }
    public static  void  main(String args[]){
/*            1
            / \
            2   3
            / \
            4   5*/
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
