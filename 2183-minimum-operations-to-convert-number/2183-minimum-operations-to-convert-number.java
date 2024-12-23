class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[]{start , 0});
        visited.add(start);
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int count = q.peek()[1];
            q.poll();
            if(node == goal)
            return count;
            if(node < 0 || node > 1000) continue;
            for(int i = 0; i < nums.length; i++){
                /*if(!visited.contains(node+nums[i]) && node+nums[i] >= 0 && node+nums[i] <= 1000){
                    q.offer(new int[]{node+nums[i] , count+1});
                    visited.add(node+nums[i]);
                }
                if(!visited.contains(node-nums[i]) && node-nums[i] >= 0 && node-nums[i] <= 1000){
                    q.offer(new int[]{node-nums[i] , count+1});
                    visited.add(node-nums[i]);
                }
                if(!visited.contains(node-nums[i]) && node-nums[i] == goal){
                    q.offer(new int[]{node-nums[i] , count+1});
                    visited.add(node-nums[i]);
                }
                if(!visited.contains(node^nums[i]) && (node^nums[i]) >= 0 && (node^nums[i]) <= 1000){
                    q.offer(new int[]{node^nums[i] , count+1});
                    visited.add(node^nums[i]);
                }*/
                int[] adjnode = {node+nums[i] , node-nums[i] , node^nums[i]};
                for(int j = 0; j < 3; j++){
                    if(adjnode[j] == goal)
                    return count+1;
                    else{
                        if(!visited.contains(adjnode[j]) && adjnode[j] >= 0 && adjnode[j] <= 1000){
                            q.offer(new int[]{adjnode[j] , count+1});
                            visited.add(adjnode[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}