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
//     public int getDecimalValue(ListNode head) {
//         ArrayList<Integer> al=new ArrayList<>();
//         while(head!=null){
//             al.add(head.val);
//             head=head.next;
//         }
//         int k=0;
//         int ans=0;
//         for(int j=al.size()-1;j>=0;j--){
//             ans+=al.get(j)*Math.pow(2,k);
//             k++;
//         }
        
//         return ans;
//     }
// }





class Solution {
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while(head!=null){
            ans=2*ans+head.val;
            head=head.next;
        }
        return ans;
    }
}