class Solution {
    boolean BS(List<Integer> l , int x){
        int s = 0;
        int e = l.size()-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(l.get(m) == x)
            return true;
            if(l.get(m) < x)
            s = m+1;
            else
            e = m-1;
        }
        return false;
    }
    public boolean judgeSquareSum(int c) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i*i <= c; i++){
            l.add(i*i);
        }
        for(int i = 0; i < l.size(); i++){
            if(BS(l , c-l.get(i)))
            return true;
        }
        return false;
    }
}