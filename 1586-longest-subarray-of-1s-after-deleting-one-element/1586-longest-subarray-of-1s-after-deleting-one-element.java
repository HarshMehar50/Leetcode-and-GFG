class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int[] a = new int[nums.length];
        while(l < nums.length){
            int c = 0;
            int r = l;
            for(r = l; r < nums.length; r++){
                if(nums[r] == 1)
                c++;
                else
                break;
            }
            for(int i = l; i <= Math.min(r , nums.length-1); i++){
                if(nums[i] == 1)
                a[i] = c;
            }
            l = r+1;
        }
        int max = 0;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max , a[i]);
        }
        int ans = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 0){
                int c = 0;
                if(i-1 >= 0)
                c += a[i-1];
                if(i+1 < a.length)
                c += a[i+1];
                ans = Math.max(ans , c);
            }
        }
        ans = Math.max(ans , max-1);
        return ans;
    }
}