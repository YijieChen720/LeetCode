public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        int ifSwap = 1;
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode tmpPre = null;
        ListNode tmpAft;
        int count = 0;

        while (cur != null) {
            if (count == 0) {
                head = cur;
            }

            tmpAft = cur.next;

            if (ifSwap == 1) {
                pre.next = tmpAft;
                cur.next = pre;
                if (count > 0) {
                    tmpPre.next = cur;
                }
                cur = tmpAft;
            }

            if (ifSwap == 0) {
                tmpPre = pre;
                pre = cur;
                cur = tmpAft;
            }

            ifSwap = (ifSwap + 1) % 2;
            count += 1;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ReverseLinkedList.ListNode next) { this.val = val; this.next = next; }
    }
}
