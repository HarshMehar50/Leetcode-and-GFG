class Solution {
    public int maximumGood(int[][] statements) {
        int ans = 0;
        for(int mask = 0; mask < (1<<statements.length); mask++){
            boolean t = true;
            for(int i = 0; i < statements.length; i++){
                if((mask&(1<<i)) == 0)
                continue;
                for(int j = 0; j < statements.length; j++){
                    int good = 0;
                    if((mask&(1<<j)) != 0)
                    good = 1;
                    if((statements[i][j] == 1 && good == 0)||(statements[i][j] == 0 && good == 1)){
                        t = false;
                        break;
                    }
                }
                if(!t)
                break;
            }
            if(t)
            ans = Math.max(ans , Integer.bitCount(mask));
        }
        return ans;
    }
}