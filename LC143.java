// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public void reorderList(ListNode head) {
//         ArrayList<Integer> al=new ArrayList<>();

//         ListNode cur = head;

//         while(cur!=null){
//             al.add(cur.val);
//             cur=cur.next;
//         }

//         ArrayList<Integer> al2 = new ArrayList<>();

//         int i=0;
//         int j=al.size()-1;

//         while(i<=j){
//             al2.add(al.get(i));
//             if(i<j){
//                 al2.add(al.get(j));
//             }
//             i++;
//             j--;
//         }

//         cur=head;
//         for(i=1;i<al2.size();i++){
//             cur.next = new ListNode(al2.get(i));
//             cur=cur.next;
//         }


//     }
// }



class Solution {
    public void reorderList(ListNode head) {
       if(head.next != null && head != null) {
       ListNode slow = head;
       ListNode fast = head.next;
       while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
       } 
       if(fast.next != null){
        slow = slow.next;
       }
       ListNode temp = slow.next;
       ListNode newHead = temp;
       slow.next = null;
       newHead = reverse(newHead, null);
       
       ListNode curr = head;
       while(newHead != null){
        ListNode node = curr.next;
        curr.next = newHead;
        newHead = node;
        curr = curr.next;
       }
    }
    }
    public ListNode reverse(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode newHead = head.next;
        head.next = prev;
        return reverse(newHead, head);
    }
}