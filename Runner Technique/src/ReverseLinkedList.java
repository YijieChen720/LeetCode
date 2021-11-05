public class ReverseLinkedList {

    private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre;
        ListNode next = head.next;
        while (next != null) {
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
        }
        head.next = null;
        return cur;
    }
}
