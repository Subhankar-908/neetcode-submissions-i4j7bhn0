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
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Stack<Integer> st=new Stack<>();
        ListNode temp=slow.next;
        slow.next=null;
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        ListNode curr=head;
        while(!st.isEmpty()){
            ListNode newnode=new ListNode(st.pop());
            ListNode nextnode=curr.next;
            curr.next=newnode;
            newnode.next=nextnode;
            curr=nextnode;
        }

        
    }
}
