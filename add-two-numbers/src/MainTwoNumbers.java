public class MainTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    private static ListNode revertListNode(ListNode listNode) {
        ListNode newListNode = new ListNode();
        if (listNode.next != null) {
            newListNode.next = revertListNode(listNode.next);
        }
        newListNode.val = listNode.val;
        return newListNode;
    }

    private static ListNode sum(ListNode l1, ListNode l2) {
        String s = listNodeToNumber(l1, "") + listNodeToNumber(l2, "");
        return null;
    }

    private static String listNodeToNumber(ListNode listNode, String val) {
        val += listNode.val;
        if (listNode.next != null)
            listNodeToNumber(listNode.next, val);
        return val;
    }
}
