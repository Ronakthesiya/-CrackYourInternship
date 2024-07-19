class Solution4 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=Integer.MAX_VALUE;
        int temppro=0;
        int finalfro=0;
        

        for(int i=0;i<n;i++){
            if(prices[i]<max){
                max=prices[i];
            }
            temppro=prices[i]-max;
            if(finalfro<temppro){
                finalfro=temppro;
            }
        }

        return(finalfro);
    }
}