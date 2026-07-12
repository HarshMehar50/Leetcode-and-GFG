class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        int[][] a = new int[arr.length][2];
        for(int i = 0; i < a.length; i++){
            a[i][0] = arr[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        int rank = 1;
        for(int i = 0; i < a.length; i++){
            ans[a[i][1]] = rank;
            if(i+1 < a.length && a[i][0] < a[i+1][0])
            rank++;
        }
        return ans;
    }
}