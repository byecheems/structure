package dataStructrue.chainaStructure;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(15);
        Scanner sc = new Scanner(System.in);
        char key = ' '; // 接收用户输入
        boolean flag = true;
        // 显示菜单
        while (flag){
            System.out.println("s:显示队列");
            System.out.println("a:添加数据");
            System.out.println("g:获取数据");
            System.out.println("h:显示队头");
            System.out.println("e:退出程序");
            key = sc.next().charAt(0);
            switch (key){
                case 's' :
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a' :
                    try {
                        System.out.println("输入一个数");
                        int num = sc.nextInt();
                        arrayQueue.addQueue(num);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g' :
                    try {
                        System.out.println("取出的数据是：" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :
                    try {
                        System.out.println("队头数据是：" + arrayQueue.peekQueueHead());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e' :
                    sc.close();
                    flag = false;
                default : break;
            }
        }
    }
}

// 使用数组模拟队列
class ArrayQueue {
    private int maxSize; // 表示队列的最大容量
    private int front; // 指向队头
    private int rear; // 指向队尾
    private int[] arr; // 模拟队列，存放数据

    public ArrayQueue() {
    }

    // 初始化队列参数
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // 判断队列是否满
    public boolean queueIsFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean queueIsEmpty(){
        return rear == front;
    }

    // 入队
    public void addQueue(int n){
        if (queueIsFull()){
            throw new RuntimeException("队满，无法加入队列");
        }
        rear++; // 队尾后移
        arr[rear] = n;
    }

    // 出队
    public int getQueue(){
        if (queueIsEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        front++; // 队头后移
        return arr[front];
    }

    // 显示队列数据
    public void showQueue(){
        if (queueIsEmpty()){
            throw new RuntimeException("队空，没有数据");
        }
        System.out.print("队列：");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("队列元素个数为:" + getNumOfQueue());
    }

    // 获取元素个数
    public int getNumOfQueue(){
        return rear - front;
    }

    // 显示队头数据
    public int peekQueueHead(){
        if (queueIsEmpty()){
            throw new RuntimeException("队空，没有队头数据");
        }
        return arr[front+1];
    }
}