public class MyLinkedList2 {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList2() {
        head = new Node(-1, null, null);
        tail = new Node(-1, null, null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node tmp = head;
        int idxTmp = 0;
        while(idxTmp <= index) {
            tmp = tmp.next;
            idxTmp += 1;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        Node first = new Node(val, head.next, head);
        head.next.prev = first;
        head.next = first;
        size += 1;
    }

    public void addAtTail(int val) {
        Node last = new Node(val, tail, tail.prev);
        last.prev.next = last;
        tail.prev = last;
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node tmp = head;
        int idxTmp = 0;
        while(idxTmp <= index) {
            tmp = tmp.next;
            idxTmp += 1;
        }

        Node insertNode = new Node(val, tmp, tmp.prev);
        insertNode.prev.next = insertNode;
        insertNode.next.prev = insertNode;
        size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        Node tmp = head;
        int idxTmp = 0;
        while(idxTmp <= index) {
            tmp = tmp.next;
            idxTmp += 1;
        }

        tmp.next.prev = tmp.prev;
        tmp.prev.next = tmp.next;
        size -= 1;
    }

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        Node(int value, Node _next, Node _prev)
        {
            val = value;
            next = _next;
            prev = _prev;
        }
    }
}
