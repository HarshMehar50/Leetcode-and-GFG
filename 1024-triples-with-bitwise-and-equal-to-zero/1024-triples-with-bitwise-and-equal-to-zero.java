class Solution {
    public int countTriplets(int[] nums) {
        /*Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                int a = nums[i]&nums[j];
                int b = 0;
                int mb = 0;
                for(int k = 0; k <= 16; k++){
                    if((a&(1<<k)) != 0){
                        mb = i;
                    }
                }
                for(int k = 0; k <= mb; k++){
                    if((a&(1<<i)) == 0)
                    b += (1<<k);
                }
                int bs = Arrays.binarySearch(nums , b);
                if(bs < nums.length && bs >= 0)
                ans++;
            }
        }
        return ans;*/
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int[] f = new int[max+1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                f[nums[i]&nums[j]]++;
            }
        }
        int ans = 0;
        for(int i = 0; i <= max; i++){
            for(int j = 0; j < nums.length; j++){
                if((nums[j]&i) == 0)
                ans += f[i];
            }
        }
        return ans;
    }
}