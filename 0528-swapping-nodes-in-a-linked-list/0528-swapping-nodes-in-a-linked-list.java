/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer k nodes ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // Invalid k value
            }
            fast = fast.next;
        }

        ListNode first = fast;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode second = slow;

        // Swap the values of the first and second nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}