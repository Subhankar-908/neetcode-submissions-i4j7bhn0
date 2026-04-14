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
        int pvalue=-1;
        while(l1!=null && l2!=null){
            pvalue=-1;
            int value=l1.val+l2.val+carry;
            pvalue=value/10;
            carry=value/10;
            l3.next=new ListNode(value%10);
            l1=l1.next;
            l2=l2.next;
            l3=l3.next;
        }
        while(l1!=null && l2==null){
            pvalue=-1;
            int value=l1.val+carry;
            pvalue=value/10;
            carry=value/10;
            l3.next=new ListNode(value%10);
            l3=l3.next;
            l1=l1.next;
        }
        while(l2!=null && l1==null){
            pvalue=-1;
            int value=l2.val+carry;
            pvalue=value/10;
            carry=value/10;
            l3.next=new ListNode(value%10);
            l3=l3.next;
            l2=l2.next;
        }
        if(pvalue>0){
            l3.next=new ListNode(pvalue);
        }
        return newhead.next;
    }
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     int v1=0;
    //     int i=0;
    //     while(l1!=null){
    //         v1+=l1.val*(Math.pow(10,i));
    //         l1=l1.next;
    //         i++;
    //     }
    //     int v2=0;
    //     int j=0;
    //     while(l2!=null){
    //         v2+=l2.val*(Math.pow(10,j));
    //         l2=l2.next;
    //         j++;
    //     }
    //     int r=v1+v2;
    //     ListNode temp=new ListNode();
    //     ListNode curr=temp;
    //     if(r==0){
    //         ListNode l=new ListNode(0);
    //         temp.next=l;
    //     }
    //     while(r>0){
    //         int newr=r%10;
    //         ListNode newNode =new ListNode(newr);
    //         temp.next=newNode;
    //         temp=newNode;
    //         r/=10;
    //     }
    //     return curr.next;
    // }


}
