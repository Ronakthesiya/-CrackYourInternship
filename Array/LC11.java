class Solution {
    public int maxArea(int[] height) {
        int c=0;
        int max=0;
        int s=0;
        int e=height.length-1;
        while(s<=e){
            if(height[s]<=height[e]){
                c=(height[s])*(e-s);
                s++;
            }else{
                c=(height[e])*(e-s);
                e--;
            }
            if(c>max){
                max=c;
            }
        }

        return max;
    }
}