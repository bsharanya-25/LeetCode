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
    public ListNode removeNodes(ListNode head) {
       
        if(head.next==null)return head;
        int maxval=Integer.MAX_VALUE;
        ListNode newnode=new ListNode(maxval);
        Stack<ListNode> stack=new Stack<ListNode>();
        stack.push(newnode);
        while(head!=null)
        {
            while(stack.peek().val<head.val)stack.pop();
            stack.peek().next=head;
            stack.push(head);
            head=head.next;
        }
        return newnode.next;
    }
}