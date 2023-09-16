class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head; // List is empty or has only one node, it's already sorted.
        // Split the list into two halves.
        ListNode middle = findMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null; // Disconnect the two halves.
        // Recursively sort both halves.
        left = sortList(left);
        right = sortList(right);
        // Merge the sorted halves.
        return merge(left, right);
    }
    // Helper function to find the middle of a linked list.
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Helper function to merge two sorted linked lists.
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If one of the lists is not empty, append it to the result.
        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }
}
