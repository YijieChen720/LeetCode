public class DesignedLinkedList {
    static class MyLinkedList {

    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int i, Node p, Node n) {
            value = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        sentinel = new Node(-1, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node ptr = sentinel;
        for (int i = 0; i < index; i += 1) {
            ptr = ptr.next;
        }
        return ptr.next.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node head = new Node(val, sentinel, sentinel.next);
        sentinel.next.prev = head;
        sentinel.next = head;
        size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tail = new Node(val, sentinel.prev, sentinel);
        sentinel.prev.next = tail;
        sentinel.prev = tail;
        size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node ptr = sentinel;
        for (int i = 0; i < index; i += 1) {
            ptr = ptr.next;
        }
        Node addAtIndex = new Node(val, ptr, ptr.next);
        ptr.next.prev = addAtIndex;
        ptr.next = addAtIndex;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        Node ptr = sentinel;
        for (int i = 0; i < index; i += 1) {
            ptr = ptr.next;
        }

        ptr.next = ptr.next.next;
        ptr.next.prev = ptr;

    }
}


// * Your MyLinkedList object will be instantiated and called as such:
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3
    }
}
