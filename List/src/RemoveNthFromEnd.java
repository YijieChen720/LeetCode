import java.util.List;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int size = 0;
        ListNode tmp = head;

        while (tmp != null) {
            size += 1;
            tmp = tmp.next;
        }

        int forwardN = size - n; // the Nth element to be removed counting forward (start from 0)
        if (forwardN == 0) {
            return head.next;
        }

        int idx = 1;
        tmp = head;

        while(idx < forwardN) {
            tmp = tmp.next;
            idx += 1;
        }

        tmp.next = tmp.next.next;

        return head;
    }
}
