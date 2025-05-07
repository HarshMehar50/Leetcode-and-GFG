class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] d = new int[2051];
        for(int i = 0; i < logs.length; i++){
            d[logs[i][0]]++;
            d[logs[i][1]]--;
        }
        for(int i = 1; i < 2051; i++){
            d[i] += d[i-1];
        }
        int ans = 0;
        for(int i = 0; i < 2051; i++){
            ans = Math.max(d[i] , ans);
        }
        int ansi = 0;
        for(int i = 0; i < 2051; i++){
            if(d[i] == ans){
                ansi = i;
                break;
            }
        }
        return ansi;
    }
}