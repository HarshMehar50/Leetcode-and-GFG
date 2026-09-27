class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<String , Integer> map = new HashMap<>();
        int basePairs = 0;
        int maxPairs = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1])
            basePairs++;
            else{
                int min = Math.min(nums[i] , nums[i+1]);
                int max = Math.max(nums[i] , nums[i+1]);
                int count = map.getOrDefault(min+" "+max , 0)+1;
                map.put(min+" "+max , count);
                maxPairs = Math.max(maxPairs , count); 
            }
        }
        return basePairs+maxPairs;
    }
}