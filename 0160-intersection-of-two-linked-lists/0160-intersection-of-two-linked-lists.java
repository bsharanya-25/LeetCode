/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null; // If either list is empty, there can be no intersection.
        }

        // Pointers for both lists.
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Traverse both lists until they intersect or reach the end.
        while (ptrA != ptrB) {
            // Move pointers to the next node. If they reach the end, reset them to the other list's head.
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // Either ptrA or ptrB is the intersection point, or they both are null.
        return ptrA;
    }
}
