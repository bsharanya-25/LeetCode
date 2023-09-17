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
    public ListNode insertionSortList(ListNode head) {
         if (head == null || head.next == null) {
            return head; // No need to sort if there are 0 or 1 nodes.
        }

        ListNode sortedList = null; // Initialize an empty sorted list.
        while (head != null) {
            ListNode current = head;
            head = head.next; // Move to the next node in the original list.

            // Find the correct position to insert 'current' into the sorted list.
            if (sortedList == null || current.val < sortedList.val) {
                current.next = sortedList;
                sortedList = current;
            } else {
                ListNode temp = sortedList;
                while (temp.next != null && temp.next.val < current.val) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
        }

        return sortedList;
        

    }
}