import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Integer> findDuplicates(int[] nums) {
        int a[] = new int[nums.length+1];
        List<Integer> al = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            a[nums[i]]++;
            if(a[nums[i]]==2) al.add(nums[i]);
        }
        
        return al;

    }
}