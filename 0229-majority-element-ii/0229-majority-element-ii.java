class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(c1 == 0 && nums[i] != e2){
                e1 = nums[i];
                c1 = 1;
            }else if(c2 == 0 && nums[i] != e1){
                e2 = nums[i];
                c2 = 1;
            }else if(nums[i] == e1)
            c1++;
            else if(nums[i] == e2)
            c2++;
            else{
                c1--;
                c2--;
            }
        }
        int nc1 = 0;
        int nc2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == e1)
            nc1++;
            else if(nums[i] == e2)
            nc2++;
        }
        if(nc1 > nums.length/3)
        ans.add(e1);
        if(nc2 > nums.length/3)
        ans.add(e2);
        return ans;
    }
}