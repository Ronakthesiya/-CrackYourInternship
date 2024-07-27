// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new ArrayList<>();

//         HashMap<List<Character> , Integer> mp=new HashMap<>();

//         for(String s:strs){
//             List<Character> set=new ArrayList<>();
//             for(char c:s.toCharArray()) set.add(c);
//             Collections.sort(set);

//             if(mp.containsKey(set)){
//                 ans.get(mp.get(set)).add(s);
//             }else{
//                 ans.add(new ArrayList<>());
//                 ans.get(ans.size()-1).add(s);
//                 mp.put(set , ans.size()-1);
//             }
//         }

//         return ans;
//     }
// }



// import java.util.AbstractList;
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<String, List<String>>();
//         for (String s : strs) {
//             char[] arr = s.toCharArray();
//             Arrays.sort(arr);
//             String key = new String(arr);
//             map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
//         }
//         return new ArrayList<List<String>>(map.values());
//     }
// }



// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
//         // for each word
//         for (String s : strs) {
//             // count the freq of char
//             int[] count = new int[26];
//             for (char c : s.toCharArray()) {
//                 count[c - 'a']++;
//             }
//             // calc the key 
//             StringBuilder sb = new StringBuilder();
//             for (int i = 0; i < 26; i++) {
//                 if (count[i] != 0) {
//                     sb.append('a' + i);
//                     sb.append(count[i]);
//                 }
//             }
//             String key = sb.toString();
//             // put in map
//             map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
//         }
//         return new ArrayList<List<String>>(map.values());
//     }
// }


/**
    Method 3: Abstract List
*/
import java.util.AbstractList;
import java.util.*;
class Solution {
    private List<List<String>> res;

    public List<List<String>> groupAnagrams(String[] strs) {        
        return new AbstractList<List<String>>() {
            public List<String> get(int index) {
                if (res == null) init();
                return res.get(index);
            }
            
            public int size() {
                if (res == null) init();
                return res.size();
            }
            
            private void init() {
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                    int[] count = new int[26];
                    for (char c : s.toCharArray()) {
                        count[c - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (count[i] != 0) {
                            sb.append('a' + i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
                    res = new ArrayList<>(map.values());
                }
            }
        };
    }
}