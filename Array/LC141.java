/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ArrayList<ListNode> al=new ArrayList<>();
//         al.add(head);

//         while(1==1){
//             if(head==null || head.next==null){
//                 return false;
//             }
//             head=head.next;
//             if(al.contains(head)){
//                 return true;
//             }
//             al.add(head);
//         }
//     }
// }



public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}