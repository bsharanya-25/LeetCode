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
    public int size(ListNode head){
        if(head==null){
            return 0;
        }
        if(head.next == null){
            return 1;
        }
        int p =0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            p++;
        }
    return p; 
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next ==null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode Next= null;
        int count = 0;
        while( curr!= null && count<k){
           Next = curr.next;
           curr.next = prev;
           prev=  curr;
           curr = Next;
           count++;
        }
        if(Next!=null && size(Next)>=k){
            head.next = reverseKGroup(Next,k);
        }
        else{
            head.next = Next;
        }
    return prev;
    }
}