class Solution {
    String ans = "";
    boolean subsequence(String s , String c , int k){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < k*c.length()){
            if(s.charAt(i) == c.charAt(j%c.length()))
            j++;
            i++;
        }
        if(j == k*c.length())
        return true;
        else
        return false;
    }
    boolean BackTrack(String s , StringBuilder c , int[] f , int k , int ml){
        if(c.length() == ml){
            if(subsequence(s , c.toString() , k)){
                ans = c.toString();
                return true;
            }
            return false;
        }
        for(int i = 25; i >= 0; i--){
            if(f[i] > 0){
                int l = c.length();
                c.append((char)('a'+i));
                f[i]--;
                if(BackTrack(s , c , f , k , ml))
                return true;
                c = c.deleteCharAt(c.length()-1);
                f[i]++;
            }
        }
        return false;
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] f = new int[26];
        for(int i = 0; i < s.length(); i++){
            f[(int)(s.charAt(i)-'a')]++;
        }
        for(int i = 0; i < 26; i++){
            f[i] = f[i]/k;
        }
        int ml = s.length()/k;
        for(int i = ml; i >= 1; i--){
            int[] t = f.clone();
            StringBuilder c = new StringBuilder();
            if(BackTrack(s , c , t , k , i))
            return ans; 
        }
        return ans;
    }
}