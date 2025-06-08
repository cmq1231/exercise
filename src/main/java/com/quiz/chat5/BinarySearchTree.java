package com.quiz.chat5;



public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // 1. 插入方法
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode current, int val) {
        // 基本情况：到达空节点时创建新节点
        if (current == null) {
            return new TreeNode(val);
        }

        // 递归插入左子树或右子树
        if (val < current.val) {
            current.left = insertRecursive(current.left, val);
        } else if (val > current.val) {
            current.right = insertRecursive(current.right, val);
        }

        return current;  // 返回未修改的现有节点
    }

    // 2. 搜索方法
    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode current, int val) {
        // 基本情况：节点为空（未找到）
        if (current == null) {
            return false;
        }

        // 检查当前节点
        if (val == current.val) {
            return true;
        }
        // 递归搜索左子树或右子树
        else if (val < current.val) {
            return searchRecursive(current.left, val);
        } else {
            return searchRecursive(current.right, val);
        }
    }

    // 3. 中序遍历方法
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);      // 遍历左子树
            System.out.print(node.val + " "); // 访问当前节点
            inorderRecursive(node.right);     // 遍历右子树
        }
    }

    // 测试示例
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 插入测试
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // 中序遍历测试（应输出升序序列）
        System.out.print("中序遍历结果: ");
        bst.inorderTraversal();  // 输出: 2 3 4 5 6 7 8
        System.out.println();

        // 搜索测试
        System.out.println("搜索 4: " + bst.search(4));  // true
        System.out.println("搜索 9: " + bst.search(9));  // false
    }
}
