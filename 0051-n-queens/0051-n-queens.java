class Solution {
    boolean check(int r , int c , List<String> inner , int n){
        for(int i = r; i >= 0; i--){
            if(inner.get(i).charAt(c) == 'Q')
            return false;
        }
        for(int i = r , j = c; i >= 0 && j >= 0; i-- , j--){
            if(inner.get(i).charAt(j) == 'Q')
            return false;
        }
        for(int i = r , j = c; i >= 0 && j < n; i-- , j++){
            if(inner.get(i).charAt(j) == 'Q')
            return false;
        }
        return true;
    }
    void solve(int n , List<List<String>> ans , List<String> inner , int r){
        if(r == n){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int i = 0; i < n; i++){
            if(check(r , i , inner , n)){
                String s = inner.get(r);
                String t = s;
                s = s.substring(0 , i)+'Q'+s.substring(i+1);
                inner.set(r , s);
                solve(n , ans , inner , r+1);
                inner.set(r , t);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String s = "";
        for(int i = 0; i < n; i++){
            s += '.';
        }
        List<String> inner = new ArrayList<>();
        for(int i = 0; i < n; i++){
            inner.add(s);
        }
        solve(n , ans , inner , 0);
        return ans;
    }
}