class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , 0);
        }
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , map.get(nums[i])+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            pq.offer(new int[]{m.getValue() , m.getKey()});
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = pq.peek()[1];
            pq.poll();
        }
        return ans;
    }
}