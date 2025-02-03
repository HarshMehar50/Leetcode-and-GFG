class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        List<Integer> g = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot)
            l.add(nums[i]);
            else if(nums[i] == pivot)
            e.add(nums[i]);
            else
            g.add(nums[i]);
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        for(int i = 0; i < e.size(); i++){
            ans[i+l.size()] = e.get(i);
        }
        for(int i = 0; i < g.size(); i++){
            ans[i+l.size()+e.size()] = g.get(i);
        }
        return ans;
    }
}