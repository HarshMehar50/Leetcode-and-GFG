class Solution {
    public int uniqueXorTriplets(int[] nums) {
        /*int ans = nums.length;
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
            if(xor == 0)
                ans++;
        } 
        if(nums.length%4 == 2 && nums.length/4 > 0)
            ans++;
        List<Integer> s = new ArrayList<>();
        for(int i = 0; (int)Math.pow(2 , i) <= nums.length; i++){
            s.add((int)Math.pow(2 , i));
        }*/
        if(nums.length < 3)
            return nums.length;
        int i = 0;
        for(i = 0; (int)Math.pow(2 , i) <= nums.length; i++);
        return (int)Math.pow(2 , i);
    }
}