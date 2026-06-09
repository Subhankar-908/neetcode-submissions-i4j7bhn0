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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0)return null;
        return margelist(lists,0,lists.length-1);
    }
    private ListNode margelist(ListNode[] list,int st ,int end){
        if(st==end){
            return list[st];
        }
        if(st+1==end){
            return marge2list(list[st],list[end]);
        }
        int mid=st+(end-st)/2;
        ListNode left=margelist(list,st,mid);
        ListNode right=margelist(list,mid+1,end);
        return marge2list(left,right);
    }
    private ListNode marge2list(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }
        return dummy.next;
    }
}
