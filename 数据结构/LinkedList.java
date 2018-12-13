package dataStructrue;

import java.security.PublicKey;

/**
 * Created by lzp on 2018/11/7.
 */

/**
 * 时间复杂度：
 * 添加：O(n)
 * addLast(e) O(n)
 * addFirst(e) O(1)
 * add(index,e) = O(n/2) = O(n)
 * 删除：O(n)
 * removeLast(e) O(n)
 * removeLast(e) O(1)
 * remove(index,e) = O(n/2) = O(n)
 * 修改：O(n)
 * set(index) O(n)
 * 查找：O(n)
 * get(index) O(n)
 * contains(e) O(n)
 *
 * 注：整体时间复杂度其实比数组的差，但是只对链表头进行操作都是O（1）,这样整体就和数组一样了。并且是动态的。节省内存
 *
 * @param <E>
 */
 class LinkedList<E> {

    private Node dummyHead;//链表虚拟头节点
    private int size;//节点个数
    //内部类
    private class Node{
        public E e;
        public  Node next;//引用
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e=e;
            this.next=null;
        }
        public Node(){
            this.e=null;
            this.next=null;
        }
        public String toSring(){
            return  e.toString();
        }
    }
    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }

    //获取链表中元素的个数元素个数
    public int getSize(){
        return size;
    }
    //是否为空
    public  boolean isEmpty(){
        return  size ==0;
    }
    //在链表的index的位置添加元素  关键：找到要添加的节点的前一个节点
    public  void add(int index,E e){
        if(index<0||index>size){
            throw  new IllegalArgumentException("参数不合法");
        }
            Node pre = dummyHead;
            for(int i=0;i<index;i++){
                pre = pre.next;
            }
            /*Node node=new Node(e);
            node.next = pre.next;
            pre.next=node;*/
            pre.next=new Node(e,pre.next);
            size++;

    }
    //node.next=head;head = node
    //链表头添加元素
    public void addFirst(E e){
        add(0,e);
    }
    //在链表末尾
    public void addLast(E e ){
        add(size,e);
    }

    //获得index位置的元素
    public E get(int index){
        if(index<0||index>size){
            throw  new IllegalArgumentException("参数不合法");
        }
        Node current = dummyHead.next;
        for (int i=0;i<index;i++){
            current = current.next;
        }
        return current.e;
    }
    //获得链表头元素
    public E getFirst(int index){
        return get(0);
    }
    //获得链表尾部元素
    public E getLast(int index0){
        return get(size-1);
    }
    //修改index位置元素
    public void set(int index,E e){
        if(index<0||index>size){
            throw  new IllegalArgumentException("参数不合法");
        }
        Node current = dummyHead.next;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        current.e=e;
    }
    //查找
    public  boolean contains(E e){
        Node current = dummyHead.next;
        while (current!=null){
            if(current.e.equals(e)){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    //删除index位置元素
    public E remove(int index){
        if(index<0||index>size){
            throw  new IllegalArgumentException("参数不合法");
        }
        Node pre = dummyHead;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next=null;
        size--;
        return delNode.e;

    }
    //删除首部
    public E removeFirst(){
        return remove(0);
    }
    //删除尾部
    public E removeLast(){
        return remove(size-1);
    }
    //toString 方法
    public String toString(){
        StringBuffer sb = new StringBuffer();
        Node current = dummyHead.next;
        while (current!=null){
            sb.append(current.e+"->");
            current=current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
