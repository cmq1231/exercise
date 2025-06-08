package com.quiz.chat6;

public class ArrayStack {
    int [] stack;
    int top;
    int capacity;

    /**
     * 初始化栈
     * @param size 初始容量
     */
    public ArrayStack(int size) {
        this.capacity = size;
        this.stack = new int[capacity];
        this.top = -1;  // 栈空时指针为-1
    }

    public boolean isFull(){
        return top==capacity-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int size(){
        return top+1;
    }
    public void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        System.arraycopy(stack,0,newStack,0,top+1);
        stack=newStack;
        capacity=newCapacity;
    }

    //peek,pop,push
    public void push(int value){
        if(isFull()){
            resize(capacity*2);
        }
        stack[++top]=value;

    }
    //返回但不出栈
    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("队列为空，没有数据可以取出");
        }
        return stack[top];
    }
    //返回但不出栈
    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("队列为空，没有数据可以出栈");
        }
        return stack[top--];
    }

    // 测试示例
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        // 测试入栈
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);  // 触发扩容
        stack.push(50);

        System.out.println("Peek: " + stack.peek());  // 输出: 50
        System.out.println("Size: " + stack.size());  // 输出: 5

        // 测试出栈
        System.out.println("Pop: " + stack.pop());    // 输出: 50
        System.out.println("Pop: " + stack.pop());    // 输出: 40
        System.out.println("Peek: " + stack.peek());  // 输出: 30

        // 测试空栈异常
        while (!stack.isEmpty()) {
            stack.pop();
        }
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
