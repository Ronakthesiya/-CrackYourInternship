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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c=0;
        ListNode save=head;
        while(save!=null){
            save=save.next;
            c++;
        }
        if(c==1)return null;
        if(n==c)return head.next;

        int k=n;
        n=c-n;
        save=head.next;
        ListNode pred=head;
        n--;
        while(n-->0){
            save=save.next;
            pred=pred.next;
        }
        if(k==c)pred.next=null;
        pred.next=save.next;

        return head;
    }
}