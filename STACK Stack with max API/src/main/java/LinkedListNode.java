package main.java;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    // Constructor.
    public LinkedListNode() { data = 0; }
    public LinkedListNode(int d) { data = d; }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        LinkedListNode it = this;

        while(it.next != null) {
            sb.append(it.data);
            sb.append(", ");
            it = it.next;
        }

        sb.append(it.data);
        sb.append("}");

        return sb.toString();
    }
}