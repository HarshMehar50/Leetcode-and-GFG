class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        for(int i = 0; i < list.size(); i++){
            if(list.contains(target-list.get(i)) && list.indexOf(target-list.get(i)) != i)
                return new int[]{i , list.indexOf(target-list.get(i))};
        }
        return new int[]{};
    }
}