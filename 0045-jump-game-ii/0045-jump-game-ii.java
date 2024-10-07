class Solution {
    /*int solve(int[] nums , int i){
        if(i >= nums.length){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j <= nums[i] && i+j < nums.length; j++){
            ans = Math.min(ans , 1+solve(nums , i+j));
        }
        return ans;
    }*/
    int BFS(int[] nums){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , nums[0] , 0});
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        while(!q.isEmpty()){
            int index = q.peek()[0];
            int n = q.peek()[1];
            int c = q.peek()[2];
            q.poll();
            if(index == nums.length-1)
            return c;
            for(int i = 0; i <= nums[index]; i++){
                if(i+index < nums.length && !visited[i+index]){
                    q.offer(new int[]{i+index , nums[i+index] , c+1});
                    visited[i+index] = true;
                }
            }
        }
        return -1;
    }
    public int jump(int[] nums) {
        return BFS(nums);
    }
}