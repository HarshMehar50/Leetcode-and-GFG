class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 1;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        Arrays.sort(nums);
        for(int i = 2; i <= max; i++){
            int fc = 0;
            for(int j = i; j <= max; j += i){
                int bs = Arrays.binarySearch(nums , j);
                if(bs >= 0 && bs < nums.length)
                fc++;
            }
            ans++;
            if(fc == 0 || (fc == 1 && (Arrays.binarySearch(nums , i) < 0 || Arrays.binarySearch(nums , i) >= nums.length)))
            ans--;
        }
        if(nums[0] == 1)
        ans--;
        return ans;
    }
}