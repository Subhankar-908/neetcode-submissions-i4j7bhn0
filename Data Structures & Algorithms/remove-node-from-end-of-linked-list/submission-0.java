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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(n==len)return head.next;
        n=len-n;
        len=1;
        ListNode curr=head;
        while(n>0 && len!=n){
            curr=curr.next;
            len++;
        }
        if(curr.next.next!=null){
            ListNode nxt=curr.next.next;
            curr.next=nxt;
            curr=nxt;
        }else{
            curr.next=null;
        }
        return head;
    }
}
