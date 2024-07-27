// class Solution {
//     public List<String> fullJustify(String[] words, int maxWidth) {
//         int i=0;
//         int l=0;
//         ArrayList<Integer> al1=new ArrayList<>();
//         ArrayList<Integer> al2=new ArrayList<>();

//         for(i=0;i<words.length;i++){
//             l+=words[i].length();
//             if(l>maxWidth){
//                 al1.add(i--);
//                 al2.add(l-words[i].length());
//                 l=0;
//             }
//             l++;
//             if(l>maxWidth){
//                 al1.add(i);
//                 l--;
//                 al2.add(l);
//                 l=0;
//             }
//         }

        
//         int m=0;
//         int word=0;
//         int space=0;
//         int ex=0;
//         ArrayList<String> ans=new ArrayList<>();
//         int k=0;
//         for(int j=0;j<al1.size();j++){
            
//             word=0;
//             space=0;
//             ex=0;
//             String in="";

//             if(j==0){
//                 word+=al1.get(j);
//                 word++;
//             }else{
//                 word=al1.get(j)-al1.get(j-1);
//             }

//             if(j==al1.size()-1){
//                 while(word-->0){
//                     in += words[m];
//                     m++;
//                     if(word!=1){
//                         in+=' ';
//                     }
//                 }

//             }else{

//                 space=maxWidth-al2.get(j);
//                 ex=space%word;
//                 space=space/word;

//                 while(word-->0){
//                     in += words[m];
//                     m++;
//                     while(ex>0){
//                         in += ' ';
//                         ex--;
//                     }
//                     int lp=space;
//                     while(lp-->0){
//                         in += ' ';
//                     }
//                 }

//             }

//             ans.add(in);
//         }

//         return ans;
//     }
// }

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int word=0;
        while(word<words.length)
        {
            int j=word-1;
            int characters=0;
            while(j+1<words.length && characters+words[j+1].length() + j+1-word<=maxWidth)
            {
                j++;
                characters+=words[j].length();
            }
            result.add(line(words,word,j,characters,maxWidth));
            word=j+1;
        }
        return result;
    }
    public String line(String words[],int start,int end, int Linelen,int max)
    {
        StringBuilder a = new StringBuilder();
        int p=1,q=0;
        if(end!=start)
        {
            p=(max-Linelen)/(end-start);
            q=(max-Linelen)%(end-start);
        }
        
        for(int i=start;i<=end;i++)
        {
            a.append(words[i]);
            if(i!=end)
            {
                if(end==words.length-1) a.append(" ");
                else {
                    for(int j=1;j<=p;j++) a.append(" ");
                    if(q-->=1) a.append(" ");
                }
            }
        }
        while(a.length()<max) a.append(" ");
        return a.toString();
    }
}