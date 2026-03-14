class Solution {
    void solve(int n , int k , StringBuilder sb , int p , List<String> ans){
        if(n == 0){
            ans.add(sb.toString());
            return ;
        }
        for(int i = 0; i < 3; i++){
            if(i != p){
                sb.append((char)(i+'a'));
                solve(n-1 , k , sb , i , ans);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(n , k , sb , -1 , ans);
        Collections.sort(ans);
        if(ans.size() >= k)
        return ans.get(k-1);
        else
        return "";
    }
}