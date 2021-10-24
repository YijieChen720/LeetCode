import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long i1 = getNumbers(l1);
//        long i2 = getNumbers(l2);
//        long sum = i1 + i2;
//        ListNode returnList = new ListNode();
//        ListNode tmp = returnList;
//        while (sum / 10 != 0) {
//            tmp.val = (int)(sum % 10);
//            tmp.next = new ListNode();
//            tmp = tmp.next;
//            sum = sum / 10;
//        }
//        tmp.val = (int)sum % 10;

        ListNode reversedL1 = reverseList(l1);
        ListNode reversedL2 = reverseList(l2);
        ListNode returnList = new ListNode();
        ListNode tmp = returnList;
        while (reversedL1 != null && reversedL2 != null) {
            tmp.val = (reversedL1.val + reversedL2.val) % 10;
            tmp = tmp.next;
            if ((reversedL1.val + reversedL2.val) >= 10) {
                tmp.val += 1;
            }
        }
        return returnList;
    }

    public long getNumbers(ListNode head) {
        ListNode tmp = head;
        long returnValue = 0;
        int digit = 0;
        while (tmp != null) {
            returnValue += Math.pow(10, digit) * tmp.val;
            digit += 1;
            tmp = tmp.next;
        }
        return returnValue;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmp = head;
        ListNode tmpBefore = head;
        ListNode tmpAfter = head.next;

        while (tmpAfter != null) {
            tmp = tmpAfter;
            tmpAfter = tmpAfter.next;
            tmp.next = tmpBefore;
            tmpBefore = tmp;
        }
        head.next = null;
        return tmp;
    }

    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode l2 = new ListNode(9);

        System.out.println(test.getNumbers(l1));
        System.out.println(test.getNumbers(l2));
        System.out.println(test.getNumbers(l1) + test.getNumbers(l2));
        ListNode returnList = test.addTwoNumbers(l1, l2);
        System.out.println(returnList.val);

    }
}
