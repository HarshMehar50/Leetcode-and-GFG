class Solution {
    public int matrixSum(int[][] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            Arrays.sort(nums[i]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        for(int j = nums[0].length-1; j >= 0; j--){
            int m = 0;
            for(int i = 0; i < nums.length; i++){
                //pq.offer(new int[]{nums[i][j] , i , j});
                m = Math.max(m , nums[i][j]);
            }
            //ans += pq.peek()[0];
            ans += m;
            /*while(!pq.isEmpty()){
                pq.poll();
            }*/
        }
        return ans;
    }
}