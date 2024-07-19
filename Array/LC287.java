// class Solution {
//     public int findDuplicate(int[] nums) {
//     HashSet<Integer> seen = new HashSet<>();
//     for (int num : nums) {
//         if (seen.contains(num)) {
//             return num;
//         }
//         seen.add(num);
//     }
//     return -1;
// }
// }

class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int count[] = new int[n];

        for(int i=0; i<n; i++){
            count[arr[i]]++;
            if(count[arr[i]]>=2) return arr[i]; 
        }

        return -1;
    }
}