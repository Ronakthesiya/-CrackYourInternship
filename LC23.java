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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null || lists.length==0) return null;

//         ArrayList<Integer> al=new ArrayList<>();
//         for(ListNode list : lists){
//             while(list!=null){
//                 al.add(list.val);
//                 list=list.next;
//             }
//         }
//         Collections.sort(al);
//         ListNode ans=new ListNode(0);
//         ListNode help=ans;
//         for(int i:al){
//             help.next=new ListNode(i);
//             help=help.next;
//         }

//         return ans.next;
//     }
// }




// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null || lists.length==0) return null;
//         ListNode ans=new ListNode(0);
//         ListNode temp = ans;

//         while(true){
//             int p=0;
//             for(int i=0;i<lists.length;i++){
//                 if(lists[p]==null || (lists[i]!=null && lists[p].val>lists[i].val)){
//                     p=i;
//                 }
//             }

//             if(lists[p]==null) break;
//             temp.next=lists[p];
//             temp=temp.next;
//             lists[p]=lists[p].next;
//         }

//         return ans.next;
//     }
// }



class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}
