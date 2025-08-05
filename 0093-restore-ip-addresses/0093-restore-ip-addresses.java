class Solution {
    void solve(String s , int i , int segments , List<String> ans , StringBuilder sb){
        if(segments == 4 && i == s.length()){
            ans.add(sb.toString());
            return;
        }
        if(segments == 4 || i == s.length())
        return;
        for(int l = 1; l <= 3 && i+l <= s.length(); l++){
            if((l > 1 && s.charAt(i) == '0')||(Integer.parseInt(s.substring(i , i+l)) > 255))
            continue;
            int pl = sb.length();
            if(segments > 0)
            sb.append(".");
            sb.append(s.substring(i , i+l));
            solve(s , i+l , segments+1 , ans , sb);
            sb.setLength(pl);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(s , 0 , 0 , ans , sb);
        return ans;
    }
}