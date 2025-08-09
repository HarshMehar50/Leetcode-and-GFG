class Solution {
    boolean predicate(int[] bloomDay , int m , int k , int x){
        List<Integer> l = new ArrayList<>();
        int c = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= x)
            c++;
            else{
                l.add(c);
                c = 0;
            }
        }
        l.add(c);
        int cb = 0;
        for(int i = 0; i < l.size(); i++){
            cb += l.get(i)/k;
        }
        if(cb >= m)
        return true;
        else
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k)
        return -1;
        int min = Integer.MAX_VALUE;
        int s = 1;
        int e = 0;
        for(int i = 0; i < bloomDay.length; i++){
            e = Math.max(e , bloomDay[i]);
            min = Math.min(min , bloomDay[i]);
        }
        s = min;
        int ans = -1;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(predicate(bloomDay , m , k , mid)){
                ans = mid;
                e = mid-1;
            }else
            s = mid+1;
        }
        return ans;
    }
}