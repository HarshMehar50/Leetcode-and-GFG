class Solution {
   /* int solve(int[] nums , int index){
        if(index < 1 && nums[index-1] < nums[index]){
            return 1;
        }
        if(index < 1 && nums[index-1] > nums[index]){
            return 0;
        }
        int include = 0;
        int exclude = 0;
        if(nums[index-1] < nums[index])
        include = 1 + solve(nums , index-1);

        exclude = solve(nums , index-1);

        int ans = Math.max(include , exclude);
        return ans;
    }*/
    int ceil(List<Integer> list , int k){
        int s = 0;
        int e = list.size()-1;
        while(s <= e){
            int m = s + (e-s)/2;
            if(list.get(m) == k){
                return m;
            }
            if(list.get(m) > k){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return s;
    }
    int solve(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > ans.get(ans.size()-1))
            ans.add(nums[i]);
            else{
                int index = ceil(ans , nums[i]);
                ans.remove(index);
                ans.add(index , nums[i]);
            }
        }
        return ans.size();
    }
    public int lengthOfLIS(int[] nums) {
        return solve(nums);
    }
}