class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int j = Arrays.binarySearch(nums , nums[i]+k);
            if(j >= 0 && j < nums.length && j != i)
            set.add(nums[i]);
            /*if(Arrays.binarySearch(nums , nums[i]-k) != -1)
            ans++;*/
        }
        System.out.println(set);
        return set.size();
    }
}