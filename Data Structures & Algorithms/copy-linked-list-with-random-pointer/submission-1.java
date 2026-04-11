/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node newHead=new Node(head.val);
        Node oldtemp=head.next;
        Node newtemp=newHead;
        Map<Node,Node> m=new HashMap<>();
        m.put(head,newHead);
        
        while(oldtemp!=null){
            Node copy=new Node(oldtemp.val);
            m.put(oldtemp,copy);
            newtemp.next=copy;
            
            oldtemp=oldtemp.next;
            newtemp=newtemp.next;
        }

        newtemp=newHead;
        oldtemp=head;
        while(oldtemp!=null){
            if(oldtemp.random!=null){
                newtemp.random=m.get(oldtemp.random);
            }
            newtemp=newtemp.next;
            oldtemp=oldtemp.next;
        }
        return newHead;
    }
}
