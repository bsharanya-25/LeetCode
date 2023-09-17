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
    public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
        // The list is empty or contains only one node, so there is no middle node to delete.
        return null;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = head;
    
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        prev = slow;
        slow = slow.next;
    }    
    
    // After the loop, slow is at the middle node, and prev is the node before it.
    prev.next = slow.next;
    return head; 
    }
}