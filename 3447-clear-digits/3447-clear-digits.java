class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122)
            st.push(s.charAt(i));
            else
            st.pop();
        }
        String rans = "";
        while(!st.isEmpty()){
            rans += st.pop();
        }
        String ans = "";
        for(int i = rans.length()-1; i >= 0; i--){
            ans += rans.charAt(i);
        }
        return ans;
    }
}