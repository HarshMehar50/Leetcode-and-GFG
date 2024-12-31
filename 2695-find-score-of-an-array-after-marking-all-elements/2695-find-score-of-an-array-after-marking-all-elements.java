class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->((x[0] != y[0])?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1])));
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i] , i});
        }
        boolean[] visited = new boolean[nums.length];
        int c = 0;
        while(!pq.isEmpty()){
            int val = pq.peek()[0];
            int index = pq.peek()[1];
            pq.poll();
            /*if(!visited[index]){
                ans += val;
                visited[index] = true;
                c++;
            }
            if(index-1 >= 0 && index-1 < nums.length && !visited[index-1]){
                visited[index-1] = true;
                c++;
            }
            if(index+1 >= 0 && index+1 < nums.length && !visited[index+1]){
                visited[index+1] = true;
                c++;
            }*/
            if(visited[index]) continue;
            ans += val;
            visited[index] = true;
            if(index-1 >= 0 && !visited[index-1])
            visited[index-1] = true;
            if(index+1 < nums.length && !visited[index+1])
            visited[index+1] = true;
        }
        return ans;
    }
}