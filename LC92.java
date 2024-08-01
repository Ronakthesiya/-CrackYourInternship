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
//     public ListNode reverseBetween(ListNode head, int left, int right) {

//         if(left==right)return head;
//         if(head.next==null) return head;

//         ListNode s1=head.next;
//         ListNode p1=head;
//         int l=left;
//         right-=left;
//         right++;
//         left-=2;
//         while(left-->0){
//             s1=s1.next;
//             p1=p1.next;
//         }
//         ListNode s2=s1;
//         ListNode p2=p1;
//         ListNode f=p1;
//         int fl=1;
//         while(right-->0){
//             if(s2==null)break;
//             f=s2.next;
//             s2.next=p2;
//             if(fl==1 && l==1){
//                 p2.next=null;
//                 fl=0;
//             }
//             p2=s2;
//             s2=f;
//         }
//         if(l==1)return p2;
//         p1.next=p2;
//         s1.next=s2;

//         return head;
//     }
// }




class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;
        if (left == right)
            return head;

        ListNode curr = head;
        ListNode t = null;
        ListNode prev = null;
        ListNode s = null;
        ListNode v = null;
        boolean f = false;

        if (left == 1) {
            f = true;
            t = curr;
        }

        int s1 = 1;

        while (curr != null) {
            if (s1 == left && !f) {
                v = prev;
                t = curr;
            }

            if (s1 == right) {
                s = curr.next;
                curr.next = null;
                break;
            }

            prev = curr;
            curr = curr.next;
            s1++;
        }

        if (!f) {
            v.next = null;
        }

        ListNode ans = reverseList(t);
        t.next = s;

        if (!f) {
            v.next = ans;
        }

        if (f) {
            head = ans;
        }

        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}