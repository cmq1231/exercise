package com.quiz.chat2;

import java.util.HashSet;

/**
 * Linked Lists
 Implement a function to detect if a linked list has a cycle. If there is a cycle,
 return the node where the cycle begins. Otherwise, return `None`.
 */
public class IsCircle {


    /*public static Node detectCircle(Node head){
        //遍历链表
        Node current=head;
        HashSet<Node> visitedNodes=new HashSet<>();
        while (current!=null){
            if(visitedNodes.contains(current)){
                return current;
            }
            visitedNodes.add(current);
            current=current.next;
        }
        return null;
    }*/

    public static Node detectCircle(Node head) {
        if (head == null || head.next == null) {
            return null; // 链表为空或只有一个节点，不可能有环
        }

        // 1. 使用快慢指针找到相遇点（如果存在环）
        Node slow = head;
        Node fast = head;

        // 寻找相遇点
        while (fast != null && fast.next != null) {
            slow = slow.next;      // 慢指针每次移动一步
            fast = fast.next.next; // 快指针每次移动两步

            if (slow == fast) {
                // 2. 找到环后，定位环的起点
                slow = head; // 将慢指针重新指向头部
                while (slow != fast) {
                    slow = slow.next; // 两个指针每次各移动一步
                    fast = fast.next;
                }
                return slow; // 返回环的起点
            }
        }

        return null; // 没有环
    }


    public static void main(String[] args) {
        // 创建带环链表: 1->2->3->4->5->3 (环从3开始)
        Node head = new Node(1);
        head.next = new Node(2);
        Node cycleStart = new Node(3);
        head.next.next = cycleStart;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = cycleStart;  // 创建环

        Node result = detectCircle(head);

        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.data);
        } else {
            System.out.println("No cycle found");
        }
        // 输出: Cycle starts at node with value: 3
    }
}
