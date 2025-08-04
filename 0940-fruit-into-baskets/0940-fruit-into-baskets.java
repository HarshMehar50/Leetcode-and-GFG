class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int ans = 0;
        HashMap<Integer , Integer> f = new HashMap<>();
        for(int r = 0; r < fruits.length; r++){
            f.put(fruits[r] , f.getOrDefault(fruits[r] , 0)+1);
            while(l <= r && f.size() > 2){
                f.put(fruits[l] , f.get(fruits[l])-1);
                if(f.get(fruits[l]) == 0)
                f.remove(fruits[l]);
                l++;
            }
            if(f.size() <= 2)
            ans = Math.max(r-l+1 , ans);
        }
        return ans;
    }
}