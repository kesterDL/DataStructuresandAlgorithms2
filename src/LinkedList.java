
public class LinkedList {

    /**
     * checking whether the list is empty;
     accessing a node to modify it or to obtain the information in it;
     traversing the list to access all elements (e.g., to print them, or to find some specific element);
     determining the size (i.e., the number of elements) of the list;
     inserting or removing a specific element (e.g., the first one, the last one, or one with a certain value);
     creating a list by reading the elements from an input stream;
     converting a list to and from an array, string, etc.
     */

    private class Node {
        int value;
        Node next;
    }

    private Node head;
    private Node tail;

    LinkedList() {
    }

    public void prepend(int value) {
        Node x = new Node();
        x.value = value;
        x.next = head;
        head = x;
        if(tail == null) {
            tail = x;
        }
    }

    public Integer size(){
        int count = 0;
        if (head == null) {
            return 0;
        }
        Node x = head;

        while (x != null) {
            count++;
            x = x.next;
        }

        return count;
    }

    public void printList() {
        Node x = head;
        while (x != null) {
            System.out.print(x.value);
            x = x.next;
        }
    }

    @Override
    public String toString() {
        Node x = head;
        String printList = "";

        while (x != null) {
            printList += " " + x.value;
            x = x.next;
        }

        return printList;
    }

    public void append(int value) {
        Node x = new Node();
        x.value = value;
        if (head == null) {
            head = x;
        }
        if (tail != null) {
            tail.next = x;
            tail = x;
        } else {
            tail = x;
        }

    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public int first() {
        return head.value;
    }

    public int last() {
        Node x = head;
        Integer value = 0;

        while (x != null) {
            x = x.next;
            if(x != null) {
                value = x.value;
            }
        }

        return value;
    }

    public void insert(int position, int value) {
        Node x = new Node();
        x.value = value;
        Node node = head;
        int location = 0;

        if(position == size()){
            append(value);
        } else if (position == 0) {
            prepend(value);
        } else {
            while (location != position - 1) {
                node = node.next;
                location++;
            }
            x.next = node.next;
            node.next = x;
        }
    }

    public void remove(int value) {
        Node y = head;
        Node x = head;
        int found = 0;
        if(head.value == value) {
            x = x.next;
            y = null;
            head = x;
        } else {
            while (found != value) {
                y = x;
                x = x.next;
                found = x.value;
            }
            y.next = x.next;
            x = null;
        }
    }

    public int find(int value) {
        Node x = head;
        int found = 0;
        int position = -1;

        while (found != value) {
            found = x.value;
            x = x.next;
            position++;
            if(x == null && found != value) {
                return -1;
            }
        }

        return position;
    }

}
