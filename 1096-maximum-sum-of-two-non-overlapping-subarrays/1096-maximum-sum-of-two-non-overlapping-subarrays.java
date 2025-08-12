class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        int ans = 0;
        for(int i = 0; i+firstLen-1 < nums.length; i++){
            int ss1 = ps[i+firstLen-1];
            if(i != 0)
            ss1 -= ps[i-1];
            for(int j = i+firstLen; j+secondLen-1 < nums.length; j++){
                int ss2 = ps[j+secondLen-1];
                if(j != 0)
                ss2 -= ps[j-1];
                ans = Math.max(ans , ss1+ss2);
            }
        }
        for(int i = 0; i+secondLen-1 < nums.length; i++){
            int ss1 = ps[i+secondLen-1];
            if(i != 0)
            ss1 -= ps[i-1];
            for(int j = i+secondLen; j+firstLen-1 < nums.length; j++){
                int ss2 = ps[j+firstLen-1];
                if(j != 0)
                ss2 -= ps[j-1];
                ans = Math.max(ans , ss1+ss2);
            }
        }
        return ans;
    }
}