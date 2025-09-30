class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> prev = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            prev.add(nums[i]);
        }
        for(int i = 0; i < nums.length-1; i++){
            List<Integer> next = new ArrayList<>();
            for(int j = 0; j < prev.size()-1; j++){
                next.add((prev.get(j)+prev.get(j+1))%10);
            }
            prev = next;
        }
        return prev.get(0);
    }
}