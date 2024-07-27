// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> s=new ArrayList<>();
//         String k="";
//         int m=0;
//         helper(s,k,n,m);

//         return s;
//     }

//     public void helper(List<String> s,String k,int n,int m){
//         if(m==0 && k.length()==2*n){
//             s.add(k);
//             return ;
//         }
//         helper(s,k+'(',n,m++);
//         helper(s,k+')',n,m--);
//     }
// }



class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) recurse(res, left + 1, right, s + "(", n);
        if (right < left) recurse(res, left, right + 1, s + ")", n);
    }
}