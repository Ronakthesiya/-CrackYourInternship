// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n=nums.length;
//         int a[]=new int[2];
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(nums[i]+nums[j]==target){
//                     a[0]=i;
//                     a[1]=j;
//                 }
//             }
//         }

//         return a;
//     }
// }

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[1]=i;
                ans[0]=map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }

        return ans;
    }
}