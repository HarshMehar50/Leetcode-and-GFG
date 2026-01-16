class Solution {
    public boolean isHappy(int n) {
        if(n == 1)
        return true;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            int s = 0;
            for(int i = n; i > 0; i = i/10){
                s += (i%10)*(i%10);
            }
            n = s;
            if(set.contains(s))
            return false; 
        }
        return true;
    }
}