class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer , List<Integer>>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i] , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(nums[i]).add(i);
        }
        for(int i = 0; i < queries.length; i++){
            if(map.get(nums[queries[i]]).size() == 1)
            ans.add(-1);
            else{
                List<Integer> l = map.get(nums[queries[i]]);
                int p = Collections.binarySearch(l , queries[i]);
                int min = Integer.MAX_VALUE;
                int left = l.get((p-1+l.size())%l.size());
                min = Math.min(min , Math.min(Math.abs(queries[i]-left) , nums.length-Math.abs(queries[i]-left))); 
                int right = l.get((p+1+l.size())%l.size());
                min = Math.min(min , Math.min(Math.abs(queries[i]-right) , nums.length-Math.abs(queries[i]-right))); 
                ans.add(min);
            }
        }
        return ans;
    }
}