class Solution {
    int gcd(int a, int b) {
        if(b == 0)
            return Math.abs(a);
        return gcd(b , a%b);
    }
    public int countDifferentSubsequenceGCDs(int[] nums) {
        /*int ans = 1;
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
        return ans;*/

        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        boolean[] present = new boolean[max+1];
        for(int i = 0; i < nums.length; i++){
            present[nums[i]] = true;
        }
        int ans = 0;
        for(int i = 1; i <= max; i++){
            int gcd = 0;
            for(int j =i; j <= max; j += i){
                if(present[j]){
                    if(gcd == 0)
                        gcd = j;
                    else
                        gcd = gcd(gcd , j);
                    if(gcd == i){
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}