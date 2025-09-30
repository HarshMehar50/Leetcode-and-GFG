class Solution {
    int floor(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m] <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        List<Long> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int f = floor(nums , queries[i]);
            long ls = 0;
            if(f != -1)
            ls = (long)((long)(f+1)*(long)queries[i])-ps[f];
            long rs = 0;
            if(f != nums.length-1){
                if(f != -1)
                rs = ps[ps.length-1]-ps[f]-(long)((long)(nums.length-f-1)*(long)queries[i]);
                else
                rs = ps[ps.length-1]-(long)((long)(nums.length-f-1)*(long)queries[i]);
            }
            ans.add(ls+rs);
        }
        return ans;
    }
}