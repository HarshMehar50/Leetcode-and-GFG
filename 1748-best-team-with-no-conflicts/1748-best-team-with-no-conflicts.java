class Solution {
    int solve(int[][] a , int c , int p){
        if(c == a.length){
            return 0;
        }
        int include = 0;
        if(p == -1 || (a[c][1] >= a[p][1] && p != -1))
        include = a[c][1]+solve(a , c+1 , c);
        int exclude = solve(a , c+1 , p);
        int ans = Math.max(include , exclude);
        return ans;
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] a = new int[ages.length][2];
        for(int i = 0; i < a.length; i++){
            a[i][0] = ages[i];
            a[i][1] = scores[i];
        }
        Arrays.sort(a,(x , y)->(x[0] != y[0])?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1]));
        return solve(a , 0 , -1);
    }
}