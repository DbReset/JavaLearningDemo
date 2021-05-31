package com.luoyj.algorithm;

public class reverseList {
    //链表反转

    public static Node sloution(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }
        //前一个结点指针
        Node preNode = null;
        //当前指针
        Node curNode = head;
        //下一个执政
        Node NextNode = null;

        while(curNode != null){
            NextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = NextNode;

        }
       return preNode;

    }

    public class Node {
        private Object data;//数据域
        private Node next;//指针域

        public Node(Object data){
            this.data = data;
        }

        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

}
