class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] a = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        List<int[]> l = new ArrayList<>();
        for(int i = a.length-1; i >= a.length-k; i--){
            l.add(a[i]);
        }
        Collections.sort(l , (x , y)->Integer.compare(x[1] , y[1]));
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = l.get(i)[0];
        }
        return ans;
    }
}