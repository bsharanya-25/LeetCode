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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(0); // Dummy node to simplify insertion
    ListNode current = dummy; // Pointer to the current node in the merged list

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }

    // If one list is exhausted, attach the remaining part of the other list
    if (list1 != null) {
        current.next = list1;
    } else {
        current.next = list2;
    }

    return dummy.next; // The merged sorted list starts from the next of the dummy node
    }   
}