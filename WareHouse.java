package dataStructrue.chainaStructure;
public class WareHouse{
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private int top = -1;
    private int maxSize;
    private int []stack;
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int data){
        if (isFull()){
            System.out.println("this stack is full");
            return;
        }
        stack[++top] = data;
        System.out.println("the "+data+" is push");
    }

public int pop () {
    if (isEmpty()){
        throw new RuntimeException("this stack is empty");
    }
    int data = stack[top--];
    return data;
    }
}

