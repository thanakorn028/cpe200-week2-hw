package cpe200.week2;

import javax.xml.soap.Node;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        tail=new PNode(i,null,tail);
        if(head==null)
            head=tail;
        else
            tail.prev.next=tail;
        size++;

        // implement your code here
    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char i=tail.data;
        PNode tmp=tail;
        if(tail==head){
            tail=head=null;
        }
        else{
            tail=tail.prev;
            tail.next=null;
            tmp.prev=null;
        }
        size--;

        return i;
        // implement your code here
    }

    public boolean search(char i) {
        PNode tmp=tail;
        while (tmp!=null)
        {
            if(tmp.data==i){
                return true;
            }
            tmp=tmp.prev;
        }
        return false;

        // implement your code here
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;
        System.out.println(tmp.data);

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp=tmp.next;
            // implement your code here
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp=tail;
        while (tmp!=null){
            System.out.print(tmp.data);
            tmp=tmp.prev;
        }
        System.out.println();
        // implement your code here
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
