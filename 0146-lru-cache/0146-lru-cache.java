class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int k,int v){
            key=k;
            value=v;
            prev=null;
            next=null;
        }
        Node(){
            key=0;
            value=0;
            prev=null;
            next=null;
        }
    }
    HashMap<Integer,Node> map;
    int size;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        size=capacity;
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node temp=map.get(key);
        remove(temp);
        AddAtFront(temp);
        return temp.value;
    }
    void remove(Node temp){
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
    }
    void AddAtFront(Node newnode){
        newnode.next=head.next;
        newnode.prev=head;
        head.next.prev=newnode;
        head.next=newnode;

    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            temp.value=value;
            remove(temp);
            AddAtFront(temp);
            return;
        }
        if(map.size()==size){
            map.remove(tail.prev.key);
            remove(tail.prev);
              map.put(key,new Node(key,value));
            AddAtFront(map.get(key));
          
            return;
        }

        map.put(key,new Node(key,value));
        AddAtFront(map.get(key));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */