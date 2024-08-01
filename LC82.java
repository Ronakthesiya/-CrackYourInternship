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



// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ArrayList<Integer> al=new ArrayList<>();
//         ArrayList<Integer> du=new ArrayList<>();
//         while(head!=null){
//             if(al.contains(head.val)){
//                 du.add(head.val);
//             }
//             else al.add(head.val);
//             head=head.next;
//         }

//         ListNode ans=new ListNode(0);
//         ListNode save=ans;

//         for(int a:al){
//             if(!du.contains(a)){
//                 save.next=new ListNode(a);
//                 save=save.next;
//             }
//         }

//         return ans.next;
//     }
// }




class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head,prev = null;

        while(temp != null){
            ListNode k = temp.next;
            
            if(temp.next != null && temp.val == temp.next.val){
                while(k != null && temp.val == k.val) {
                    k = k.next;
                }
                if( prev == null && k == null) {
                    head = null;
                    break;
                }
                else if(prev == null){
                    head = k;
                    temp = head;
                    prev = null;
                }
                else if( k == null){
                    prev.next = null;
                    break;
                } else {
                    prev.next = k;
                    temp = prev;
                }
                continue;
            }

            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}