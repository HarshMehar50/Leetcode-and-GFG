class Solution {
    boolean allSame(List<Integer> l){
        int s = l.get(0);
        for(int i = 1; i < l.size(); i++){
            if(s != l.get(i))
            return false;
        }
        return true;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        List<Integer> d = new ArrayList<>();
        for(int i = 0; i < nums.length-1; i++){
            d.add(nums[i+1]-nums[i]);
        }
        int ans = 0;
        for(int i = 3; i <= nums.length; i++){
            int ws = i-1;
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < ws; j++){
                l.add(d.get(j));
            }
            if(allSame(l))
            ans++;
            for(int j = ws; j < d.size(); j++){
                l.remove(0);
                l.add(d.get(j));
                if(allSame(l))
                ans++;
            }
        }
        return ans;
    }
}