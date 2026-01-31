class Solution {
    int LIS(List<Integer> l){
        int[] a = new int[l.size()];
        int ans = 0;
        for(Integer x : l){
            int s = 0;
            int e = ans;
            while(s < e){
                int m = s+(e-s)/2;
                if(a[m] >= x)
                    e = m;
                else
                    s = m+1;
            }
            a[s] = x;
            if(s == ans)
                ans++;
        }
        return ans;
    }
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            List<Integer>l = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if((nums[j]&(1<<i)) != 0)
                    l.add(nums[j]);
            }
            ans = Math.max(ans , LIS(l));
        }
        return ans;
    }
}