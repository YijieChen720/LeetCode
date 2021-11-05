public class ReverseLinkedList {
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
