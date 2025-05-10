class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , 0);
        }
        for(int i = 0; i < nums.length; i++){
            int v = map.get(nums[i]);
            map.put(nums[i] , v+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[1] , x[1]));
        for(Integer x : map.keySet()){
            pq.offer(new int[]{x , map.get(x)});
        }
        for(int i = 0; i < k; i++){
            ans[i] = pq.peek()[0];
            pq.poll();
        }
        return ans;
    }
}