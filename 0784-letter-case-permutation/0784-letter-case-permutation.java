class Solution {
    void solve(StringBuilder sb , int i , List<String> ans){
        if(i >= sb.length()){
            ans.add(sb.toString());
            return;
        }
        char c = sb.charAt(i);
        solve(sb , i+1 , ans);
        if(c >= 'a' && c <= 'z'){
            sb.setCharAt(i , (char)(c-32));
            solve(sb , i+1 , ans);
            sb.setCharAt(i , c);
        }
        if(c >= 'A' && c <= 'Z'){
            sb.setCharAt(i , (char)(c+32));
            solve(sb , i+1 , ans);
            sb.setCharAt(i , c);
        } 
    }
    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<String> ans = new ArrayList<>();
        solve(sb , 0 , ans);
        return ans;
    }
}