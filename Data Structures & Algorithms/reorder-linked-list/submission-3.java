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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //find middle
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode temp=slow.next;
        slow.next=null;
        ListNode midd=reverse(temp);

        ListNode curr=head;
        while(midd!=null){
            
            ListNode nextnode=curr.next;
            ListNode newnode=midd.next;
            curr.next=midd;
            midd.next=nextnode;
            curr=nextnode;
            midd=newnode;
        }

        
    }

    public  ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
}
