class Solution {
    public boolean canJump(int[] nums) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , nums[0]});
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        while(!q.isEmpty()){
            int index = q.peek()[0];
            int n = q.peek()[1];
            q.poll();
            if(index == nums.length-1)
                return true;
            for(int i = 0; i <= nums[index]; i++){
                if(i+index < nums.length && !visited[i+index]){
                    q.offer(new int[]{i+index , nums[i+index]});
                    visited[i+index] = true;
                }
            }
        }
        return false;
    }
}