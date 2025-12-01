class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] a1 = new int[n+1];
        int[] a2 = new int[n+1];
        for(int i = 0; i < trust.length; i++){
            a1[trust[i][0]]++;
            a2[trust[i][1]]++;
        }
        for(int i = 1; i <= n; i++){
            if(a1[i] == 0 && a2[i] == n-1)
            return i;
        }
        return -1;
    }
}