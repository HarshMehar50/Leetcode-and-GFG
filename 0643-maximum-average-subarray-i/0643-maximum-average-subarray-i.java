class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double s = 0;
        for(int i = 0; i < k; i++){
            s += nums[i];
        }
        List<Double> list = new ArrayList<>();
        list.add(s);
        for(int i = k; i < nums.length; i++){
            s = s + nums[i] - nums[i-k];
            list.add(s);
        }
        Collections.sort(list);
        double a = list.get(list.size()-1)/k;
        return a;
    }
}