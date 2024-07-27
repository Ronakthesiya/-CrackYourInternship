import java.util.Stack;

class Solution212 {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else{
                if(st.size()==0){
                    st.clear();
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(st.pop()!='('){
                        st.clear();
                        return false;
                    }
                }else
                if(s.charAt(i)=='}'){
                    if(st.pop()!='{'){
                        st.clear();
                        return false;
                    }
                }else
                if(s.charAt(i)==']'){
                    if(st.pop()!='['){
                        st.clear();
                        return false;
                    }
                }
            }
        }
        if(st.size()==0){
            st.clear();
            return true;
        }else{
            st.clear();
            return false;
        }
        
    }
}