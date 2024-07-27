class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs[0].equals("")){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String temp="";
        String ans="";
        int a=0;
        int flag=1;
        
        for(int i=0;i<=strs[0].length();i++){
            temp=strs[0].substring(0,i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].equals("")){
                    return "";
                }
                if(strs[j].indexOf(temp)!=0){
                    flag=0;
                    break;
                }
            }
            if(flag==0){
                break;
            }
            ans=temp;
        }

        return ans;
    }
}