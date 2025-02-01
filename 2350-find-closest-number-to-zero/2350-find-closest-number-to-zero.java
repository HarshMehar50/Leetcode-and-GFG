class Solution {
    public int findClosestNumber(int[] nums) {
        List<Integer>  l = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(Math.abs(nums[i]) , min);
        }
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) == min)
            l.add(nums[i]);
        }
        Collections.sort(l);
        return l.get(l.size()-1);
    }
}