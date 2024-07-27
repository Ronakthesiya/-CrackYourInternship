import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];

        for(int[] a:dp) Arrays.fill(a,-1);

        return fun(0,1,prices,dp);
    }

    public int fun(int i,int buy,int[] arr,int[][] dp){
        if(i==arr.length) return 0;

        if(dp[i][buy]!=-1) return dp[i][buy];

        int profit = 0;
        if(buy==1){
            profit = Math.max(-arr[i]+fun(i+1,0,arr,dp) , fun(i+1,1,arr,dp));
        }else{
            profit = Math.max(arr[i]+fun(i+1,1,arr,dp), fun(i+1,0,arr,dp));
        }

        return dp[i][buy]=profit;
    }
}

