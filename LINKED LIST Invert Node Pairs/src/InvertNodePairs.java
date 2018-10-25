public class InvertNodePairs
{
    public static void main(String[] args) {

        //TODO: add proper unit testing.
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = invertNodePairs(head);

        System.out.print(head.toString());
    }

    public static Node invertNodePairs(Node head)
    {
        if(head == null) return null;
        if(head.next == null) return head;

        Node dummyHead = new Node();
        Node p1, p2, prev;

        dummyHead.next = head;
        prev = dummyHead;

        do {
            // Shift p1 and p2 accordingly.
            p1 = prev.next;
            p2 = prev.next.next;

            // Swap positions.
            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            // Set new previous for next iteration.
            prev = p1;
        } while(prev.next != null && prev.next.next != null);

        return dummyHead.next;
    }

    public static class Node
    {
        int data;
        Node next;

        // Constructor.
        Node(int d) { data = d; }
        Node() { data = 0; }

        public String toString() {
            String str = new String();
            Node iterator = this;

            while(iterator.next != null) {
                str += iterator.data + " -> ";
                iterator = iterator.next;
            }

            str += iterator.data;

            return str;
        }
    }
}
