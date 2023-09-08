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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to change if there are 0 or 1 nodes
        }

        ListNode oddHead = head; // Head of the odd-linked list
        ListNode evenHead = head.next; // Head of the even-linked list
        ListNode odd = oddHead;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next; // Connect odd to the next odd node
            odd = odd.next;
            even.next = odd.next; // Connect even to the next even node
            even = even.next;
        }

        odd.next = evenHead; // Connect the last odd node to the first even node

    return oddHead;
    }
}