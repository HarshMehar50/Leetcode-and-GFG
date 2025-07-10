class Solution {
    public String getPermutation(int n, int k) {
        int f = 1;
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            f = f*i;
            l.add(i);
        }
        f = f/n;
        String ans = "";
        k--;
        while(!l.isEmpty()){
            ans += l.get(k/f);
            l.remove(k/f);
            if(l.isEmpty())
            break;
            k = k%f;
            f = f/l.size();
        }
        return ans;
    }
}