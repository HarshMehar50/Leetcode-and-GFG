class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j = nums[i]; j > 0; j = j/10){
                inner.add(j%10);
            }
            Collections.reverse(inner);
            l.addAll(inner);
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}