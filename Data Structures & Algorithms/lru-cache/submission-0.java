class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            prev=next=null;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    HashMap<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }
    private void remove(Node node){
        Node oldprev=node.prev;
        Node oldnext=node.next;

        oldprev.next=oldnext;
        oldnext.prev=oldprev;
    }
    private Node insert(int key,int value){
        Node nwnode=new Node(key ,value);
        Node oldnode=head.next;

        head.next=nwnode;
        nwnode.prev=head;

        nwnode.next=oldnode;
        oldnode.prev=nwnode;

        return nwnode;

    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int ans =map.get(key).value;
        Node node=map.get(key);
        remove(node);
        map.remove(key);

        Node nwnode=insert(key,ans);
        map.put(key,nwnode);

        return ans;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
            map.remove(key);
        }
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        
        Node nwnode=insert(key,value);
        map.put(key,nwnode);
    }

}
