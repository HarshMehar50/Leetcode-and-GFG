class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int[] pe = new int[nums.length];
        if(nums[0]%2 == 0)
        pe[0]++;
        for(int i = 1; i < nums.length; i++){
            pe[i] = pe[i-1];
            if(nums[i]%2 == 0)
            pe[i]++;
        }
        double r = (double)((double)a/(double)b);
        int ans = 0;
        for(int l = 1; l <= nums.length; l++){
            for(int i = 0; i+l-1 < nums.length; i++){
                int ne = pe[i+l-1];
                if(i != 0)
                ne -= pe[i-1];
                int no = l-ne;
                if(no != 0){
                    double nr = (double)((double)ne/(double)no);
                    if(nr <= r)
                    ans++;
                }
            }
        }
        return ans;
    }
}