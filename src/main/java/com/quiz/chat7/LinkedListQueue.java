package com.quiz.chat7;

public class LinkedListQueue {
    private static class Node {
        int data;       // 节点存储的数据
        Node next;      // 指向下一个节点的指针

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // 构造函数
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size() {
        return size;
    }
    //入队
    public void enqueue(int value){
        Node node=new Node(value);
        if(size==0){
            front=node;
            rear=node;
        }else {
            rear.next=node;
            rear=node;
        }
        size++;
    }

    //出队
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        int value=front.data;
        front=front.next;
        size--;
        if(isEmpty()){
            rear=null;
        }
        return value;
    }

    //取队列头部元素
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return front.data;
    }
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        // 测试入队
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek());  // 应该输出: 10
        System.out.println("Size: " + queue.size());  // 应该输出: 3

        // 测试出队
        System.out.println("Dequeue: " + queue.dequeue());  // 应该输出: 10
        System.out.println("Dequeue: " + queue.dequeue());  // 应该输出: 20

        System.out.println("Size: " + queue.size());  // 应该输出: 1

        // 测试队首元素
        System.out.println("Peek: " + queue.peek());  // 应该输出: 30

        // 测试空队列操作
        System.out.println("Dequeue: " + queue.dequeue());  // 应该输出: 30
        System.out.println("Size: " + queue.size());        // 应该输出: 0
        System.out.println("Is empty: " + queue.isEmpty()); // 应该输出: true

        try {
            queue.dequeue();  // 应该抛出异常
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

