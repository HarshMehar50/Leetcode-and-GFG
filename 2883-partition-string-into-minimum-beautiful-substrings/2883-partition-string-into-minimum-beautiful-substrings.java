class Solution {
    boolean valid(String s){
        /*int n = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 1)
            n += Math.pow(2 , s.length()-1-i);
        }
        int p = (int)(Math.log(n)/Math.log(5));
        if(Math.pow(5 , p) == n)
        return true;
        else
        return false;*/
        if (s.charAt(0) == '0') 
        return false;
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            n = n * 2 + (s.charAt(i) - '0');
        }
        if (n == 0) return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
    int solve(String s , int i){
        if(i >= s.length())
        return 0;
        int ans = s.length()+1;
        for(int j = i; j < s.length(); j++){
            if(valid(s.substring(i , j+1)))
            ans = Math.min(ans , 1+solve(s , j+1));
        }
        return ans;
    }
    public int minimumBeautifulSubstrings(String s) {
        int ans = solve(s , 0);
        if(ans == s.length()+1)
        return -1;
        else
        return ans;
    }
}