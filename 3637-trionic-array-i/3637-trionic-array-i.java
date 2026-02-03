class Solution {
    boolean valid(int[] nums , int s , int e , boolean order){
        if(order){
            /*if(e-s+1 == 1)
                return false;*/
            for(int i = s; i < e; i++){
                if(nums[i] >= nums[i+1])
                    return false;
            }
            return true;
        }else{
            /*if(e-s+1 == 1)
                return false;*/
            for(int i = s; i < e; i++){
                if(nums[i] <= nums[i+1])
                    return false;
            }
            return true;
        }
    }
    public boolean isTrionic(int[] nums) {
        if(nums.length <= 3)
        return false;            
        for(int i = 1; i < nums.length-2; i++){
            int p = i;
            int l1 = p+1;
            if(valid(nums , 0 , p , true)){
                for(int j = p+1; j < nums.length-1; j++){
                    int q = j;
                    int l2 = q-p+1;
                    int l3 = nums.length-q;
                    if(valid(nums , p , q , false) && valid(nums , q , nums.length-1 , true))
                        return true;
                }
            }
        }
        return false;
    }
}