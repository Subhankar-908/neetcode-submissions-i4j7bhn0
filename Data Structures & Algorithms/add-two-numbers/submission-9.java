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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode newhead=l3;
        int carry=0;
        while(carry!=0 || l1!=null || l2!=null){
            int v1= l1!=null ? v1=l1.val : 0;
            int v2= l2!=null ? v2=l2.val : 0;
                
            int value=v1+v2+carry;
            carry=value/10;
            l3.next=new ListNode(value%10);
            l3=l3.next;

            l1= l1!=null ? l1=l1.next : null;
            l2= l2!=null ? l2=l2.next : null;

        }
        
        return newhead.next;
        
        //aproch-ii
        // ListNode l3=new ListNode(0);
        // ListNode newhead=l3;
        
        // int carry=0;
        // while(l1!=null || l2!=null){

        //     int value=0+carry;
        //     if(l1!=null){
        //         value+=l1.val;
        //         l1=l1.next;
        //     }
        //     if(l2!=null){
        //         value+=l2.val;
        //         l2=l2.next;
        //     }
        //     carry=value/10;
        //     l3.next=new ListNode(value%10);
        //     l3=l3.next;
        // }
        // if(carry==1){
        //     l3.next=new ListNode(carry);
        // }
        // return newhead.next;
    }
    
}
