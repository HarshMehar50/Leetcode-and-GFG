// User function Template for Java

class Solution {
    public int TotalPairs(int[] nums, int k) {
        // Code here
        Arrays.sort(nums);
        int ans = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int bs1 = Arrays.binarySearch(nums , nums[i]-k);
            if(bs1 != i && bs1 >= 0 && bs1 < nums.length)
            set.add(nums[i]+" "+nums[bs1]);
        }
        return set.size();
    }
}