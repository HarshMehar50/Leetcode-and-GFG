class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums1.length%2 == 0 && nums2.length%2 == 0)
        return 0;
        else if(nums1.length%2 == 1 && nums2.length%2 == 0){
            int ans = 0;
            for(int i = 0; i < nums2.length; i++){
                ans ^= nums2[i];
            }
            return ans;
        }else if(nums1.length%2 == 0 && nums2.length%2 == 1){
            int ans = 0;
            for(int i = 0; i < nums2.length; i++){
                ans ^= nums2[i];
            }
            return ans;
        }else{
            int ans = 0;
            for(int i = 0; i < nums1.length; i++){
                ans ^= nums1[i];
            }
            for(int i = 0; i < nums2.length; i++){
                ans ^= nums2[i];
            }
            return ans;
        }
    }
}