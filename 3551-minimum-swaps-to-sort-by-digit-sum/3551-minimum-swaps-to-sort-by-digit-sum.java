class Solution {
    int sum(int n){
        int s = 0;
        for(int i = n; i > 0; i=i/10){
            int d = i%10;
            s += d;
        }
        return s;
    }
    public int minSwaps(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->(x[1] != y[1])?Integer.compare(x[1] , y[1]):Integer.compare(x[0] , y[0]));
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i] , sum(nums[i]) , i});
        }
        int[][] sorted = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            sorted[i][0] = pq.peek()[0];
            sorted[i][1] = pq.peek()[2];
            pq.poll();
        }
        boolean[] visited = new boolean[nums.length];
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(sorted[i][0] , i);
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i] && map.get(nums[i]) != i){
                int c = 0;
                int j = i;
                while(!visited[j]){
                    visited[j] = true;
                    j = map.get(nums[j]);
                    c++;
                }
                if(c > 1)
                    ans += c-1;
            }
        }
        return ans;
    }
}