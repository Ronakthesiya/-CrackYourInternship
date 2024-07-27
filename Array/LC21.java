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
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ArrayList<Integer> al=new ArrayList<>();

//         while(list1!=null){
//             al.add(list1.val);
//             list1=list1.next;
//         }
//         while(list2!=null){
//             al.add(list2.val);
//             list2=list2.next;
//         }

//         Collections.sort(al);

//         if(al.size()==0){
//             return null;
//         }

//         ListNode l=new ListNode(al.get(0));
//         ListNode save=l;

//         for(int i=1;i<al.size();i++){
//             ListNode n=new ListNode(al.get(i));
//             save.next=n;
//             save=n;
//         }

//         return l;
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode l=new ListNode();
        if(list1.val<=list2.val){
            l.val=(list1.val);
            list1=list1.next;
        }else{
            l.val=(list2.val);
            list2=list2.next;
        }

        ListNode s=l;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                ListNode n=new ListNode(list1.val);
                s.next=n;
                s=n;
                list1=list1.next;
            }else{
                ListNode n=new ListNode(list2.val);
                s.next=n;
                s=n;
                list2=list2.next;
            }
        }

        while(list1!=null){
            ListNode n=new ListNode(list1.val);
            s.next=n;
            s=n;
            list1=list1.next;
        }

        while(list2!=null){
            ListNode n=new ListNode(list2.val);
            s.next=n;
            s=n;
            list2=list2.next;
        }

        return l;
    }
}