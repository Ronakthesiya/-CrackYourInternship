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
//     public boolean isPalindrome(ListNode head) {
        
//         ListNode temp = head;
//         long num = 0;
//         long rev = 0;
//         long mul = 1;

//         while(temp != null) {

//             num = num * 10 + temp.val;
//             rev = rev + temp.val * mul; 
//             mul *= 10;

//             temp = temp.next;
//         }

//         return num == rev;

//     }
// }


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        String num = "";
        while(head!=null){
            num += Integer.toString(head.val);
            head = head.next;
        }
        StringBuilder sb = new StringBuilder(num);
        sb.reverse();
        return num.equals(sb.toString());
    }
}