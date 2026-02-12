class Solution {
    public int longestBalanced(String s) {
        int[][] ps = new int[s.length()+1][26];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 26; j++){
                ps[i+1][j] = ps[i][j];
            
            }
            ps[i+1][(int)(s.charAt(i)-'a')]++;
        }
        for(int l = s.length(); l >= 1; l--){
            for(int i = 0; i+l <= s.length(); i++){
                int[] f = new int[26];
                for(int j = 0; j < 26; j++){
                    f[j] = ps[i+l][j]-ps[i][j];
                }
                int mf = 0;
                boolean mark = true;
                for(int j = 0; j < 26; j++){
                    if(f[j] != 0){
                        if(mf == 0)
                            mf = f[j];
                        else if(f[j] != mf){
                            mark = false;
                            break;
                        }
                    }
                }
                if(mark)
                    return l;
            }
        }
        return 1;
    }
}