class Solution {
    public boolean threeFibonacciSum(int n) {
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);
        while(l.get(l.size()-1) < n){
            l.add(l.get(l.size()-1)+l.get(l.size()-2));
        }
        for(int i = 1; i < l.size()-1; i++){
            if(l.get(i-1)+l.get(i)+l.get(i+1) == n)
            return true;
        }
        return false;
    }
}