public class RemoveLinkedListElement {
    /**
     * Definition for singly-linked list.
     */

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) {
             this.val = val;
         }
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }


    public static ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode ptr = head;

        while (ptr.next != null) {

            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            }

            else {
                ptr = ptr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
         ListNode ln = new ListNode();
//         ln.next = new ListNode(2);
//        ln.next.next = new ListNode(3);
//        ln.next.next.next = new ListNode(4);
//        ln.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next = new ListNode(6);
        ListNode removed = removeElements(ln, 1);
    }
}
