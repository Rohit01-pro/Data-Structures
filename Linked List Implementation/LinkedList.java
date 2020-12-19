public class LinkedList {
    Node Head; // Main Node

    // Class for Node
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return Head == null;
    }

    void add(int val) {
        Node newNode = new Node(val);
        if (Head == null)
            Head = newNode;
        else {
            Node temp = Head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    void display() {
        if (Head == null)
            System.out.println("List is Empty.");
        else {
            System.out.println("\n\nList: ");
            Node temp = Head;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }
        }
    }

    void sort() {
        Node temp = Head;
        try {
            while (temp != null) {

                Node start = temp;
                while (start != null) {
                    if (start.data < temp.data) {
                        int t = start.data;
                        start.data = temp.data;
                        temp.data = t;
                    }
                    start = start.next;
                }
                temp = temp.next;
            }
        } catch (Exception ex) {
        }
    }

    void removeDuplicateNode() {
        Node temp = Head;
        sort();
        try {
            while (temp != null) {
                if (temp.data == temp.next.data)
                    temp.next = temp.next.next;
                else
                    temp = temp.next;
            }
        } catch (Exception ex) {
        }
    }

    void insertPos(int data, int pos) {
        Node newnode = new Node(data);
        Node temp = Head;

        if (Head == null)
            Head = newnode;
        else if (Head.next == null && pos == 2)
            Head.next = newnode;
        else {
            while (pos-- > 2)
                temp = temp.next;
            Node t = temp.next;
            temp.next = newnode;
            newnode.next = t;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertPos(10,1);
        list.insertPos(20,2);
        list.insertPos(30,3);
        list.insertPos(40,4);

        list.display();

        list.insertPos(50, 5);
        list.display();

        list.insertPos(60, 6);
        list.display();

    }
}
