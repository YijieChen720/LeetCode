import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode resDummy = new ListNode(-1, null);
        ListNode p = resDummy;

        int sum;
        int carry = 0;

        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1 = p1.next;
            p2 = p2.next;

            p.next = new ListNode(sum % 10, null);
            carry = sum / 10;

            p = p.next;

            if (p1 == null && p2 == null && carry == 0) break;
            if (p1 == null) p1 = new ListNode(0, null);
            if (p2 == null) p2 = new ListNode(0, null);
        }

        return resDummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(1, new ListNode(9, null));
        ListNode l2 = new ListNode(9);

        ListNode returnList = test.addTwoNumbers(l1, l2);
        System.out.println(returnList);
    }
}
