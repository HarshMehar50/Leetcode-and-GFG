class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(new int[]{start , 0});
        visited.add(start);
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int distance = q.peek()[1];
            q.poll();
            if(node == goal)
            return distance;
            if(node >= 0 && node <= 1000){
                for(int i = 0; i < nums.length; i++){
                    if(!visited.contains(node+nums[i])){
                        q.offer(new int[]{node+nums[i] , distance+1});
                        visited.add(node+nums[i]);
                    }
                    if(!visited.contains(node-nums[i])){
                        q.offer(new int[]{node-nums[i] , distance+1});
                        visited.add(node-nums[i]);
                    }
                    if(!visited.contains(node^nums[i])){
                        q.offer(new int[]{node^nums[i] , distance+1});
                        visited.add(node^nums[i]);
                    }
                }
            }
        }
        return -1;
    }
}