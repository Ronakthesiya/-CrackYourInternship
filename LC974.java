import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ans = 0;
        int sum = 0;
        int temp = 0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            temp = (sum%k + k)%k;
            mp.put(temp , mp.getOrDefault(temp , 0)+1);
            ans += mp.get(temp)-1;
        }

        return ans;
    }
}