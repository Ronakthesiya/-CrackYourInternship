import java.util.*;

class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;

            int s=i+1;
            int e=n-1;
            
            while(s<e){
                long sum=nums[i];
                sum+=nums[s];
                sum+=nums[e];

                if(sum==0){
                    List<Integer> a=new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[s]);
                    a.add(nums[e]);
                    ans.add(a);

                    s++;
                    e--;
                    while(s<e && nums[e]==nums[e+1])e--;
                    while(s<e && nums[s]==nums[s-1])s++;
                }else if(sum>0) e--;
                else s++;
            }
        }

        return ans;
    }
}