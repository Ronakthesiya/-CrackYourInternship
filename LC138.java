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
        if(head==null){
            return null;
        }
        // creation of HashMap
        Map<Node,Node> map=new HashMap();
        Node curr=head;
        // Store all the nodes and its values in the hash map as a key-value pairs.
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        for(Node key: map.keySet()){
            Node duplicate=map.get(key);
            duplicate.next=map.get(key.next);
            duplicate.random=map.get(key.random);
        }
        return map.get(head);
    }
}