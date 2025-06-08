package com.quiz.chat2;

import java.util.HashSet;

/**
 * Linked Lists
 Implement a function to detect if a linked list has a cycle. If there is a cycle,
 return the node where the cycle begins. Otherwise, return `None`.
 */
public class IsCircle {


    public static Node dectectCircle(Node head){
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
    }
    public static void main(String[] args) {
        // 创建带环链表: 1->2->3->4->5->3 (环从3开始)
        Node head = new Node(1);
        head.next = new Node(2);
        Node cycleStart = new Node(3);
        head.next.next = cycleStart;
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = cycleStart;  // 创建环

        Node result = dectectCircle(head);

        if (result != null) {
            System.out.println("Cycle starts at node with value: " + result.data);
        } else {
            System.out.println("No cycle found");
        }
        // 输出: Cycle starts at node with value: 3
    }
}
