import java.util.List;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmpMove = head;
        ListNode tmpBefore = head;
        ListNode tmpAfter = head.next;

        while (tmpAfter != null) {
            tmpMove = tmpAfter;
            tmpAfter = tmpMove.next;
            tmpMove.next = tmpBefore;
            tmpBefore = tmpMove;
        }

        head.next = null;
        head = tmpMove;
        return head;
    }

    public static void main(String[] args) {
        ListNode head;
        head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        reverseList(head);
    }
}
