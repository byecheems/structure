package dataStructrue.chainaStructure;
public class LinkedList{
    public static void main(String[] args) {

    }
}
class LinkNode {

    private int data; //数据
    private LinkNode nextNode;  //下一节点

    public LinkNode(int input) {
        data = input;
        nextNode = null;
    }

    //寻找最末尾节点并添加新节点
    public LinkNode append(LinkNode appended) {
        LinkNode currentNode = this;
        while(currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = appended;
        return this;
    }

    //获取节点数据
    public int getData() {
        return data;
    }

    //获取下一个节点
    public LinkNode getNextNode() {
        return nextNode;
    }

    //设置下一个节点的指针，主要是为插入做准备
    protected boolean setNextNode(LinkNode node) {
        if(nextNode == null) {
            nextNode = node;
            return true;
        } else return false;
    }

    //判断当前节点是否是最后一个
    public boolean isLast() {
        return nextNode == null;
    }

    //删除下一个节点
    public boolean removeNext() {
        LinkNode next;
        if((next = this.nextNode) != null) {
            this.nextNode = next.nextNode;
            return true;
        }
        return false;
    }

    //插入一个节点作为当前节点的下一节点
    public boolean insertNext( LinkNode inserted) {
        if(inserted.setNextNode(this.nextNode)) {
            this.nextNode = inserted;
            return true;
        }
        else return false;
    }

    //显示所有节点信息
    public void show() {
        LinkNode current = this;
        StringBuilder sb = new StringBuilder(String.valueOf(current.getData()));
        while(!current.isLast()) {
            current = current.nextNode;
            sb.append(current.getData());
        }
        System.out.println("当前链表：" + sb);
    }
}