// class Solution {
//     public String reverseWords(String s) {
//         s = s.trim();
//         s = " " + s;
//         String ans = "";
//         String word = "";
//         int i=s.length()-1;
//         while(i >= 0){
//             if(s.charAt(i) != ' ' && i!=0){
//                 word += s.charAt(i);
//             }
//             else{
//                 word += s.charAt(i);
//                 ans += new StringBuffer(word).reverse().toString();
//                 word = "";
//             }
//             i--;
//         }
//         return ans.trim();
//     }
// }

// class Solution {
//     public String reverseWords(String s) {
//         String[] str = s.trim().split("\\s+");
//         String out = "";
//         for (int i = str.length - 1; i > 0; i--) {
//             out += str[i] + " ";
//         }
//         return out + str[0];
//     }
// }

class Solution {
    public static String reverseWords(String s) {
        char[] a = s.toCharArray();
        char[] res = new char[a.length];
        int i = a.length - 1, j, k, r = 0;

        while (i >= 0 && a[i] == ' ') i--;

        while (i >= 0) {
            j = i; // end word

            while (i >= 0 && a[i] != ' ') i--; // find end
            if (r > 0) res[r++] = ' ';  // add ' ' to res[]

            // reverse word and copy
            for (k = i + 1; k <= j; k++) res[r++] = a[k];  

            // clear excess space
            while (i >= 0 && a[i] == ' ') i--; 
        }
        return new String(res, 0, r);
    }
}