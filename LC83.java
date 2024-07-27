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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pred=head;
        ListNode save=head.next;

        while(save != null){
            if(pred.val == save.val){
                pred.next = save.next;
                save =save.next;
            }else{
            pred=save;
            save=save.next;
            }
        }

        return head;
    }
}