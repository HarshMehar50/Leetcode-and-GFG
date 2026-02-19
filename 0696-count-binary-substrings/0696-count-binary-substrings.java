class Solution {
    public int countBinarySubstrings(String s) {
        /*int[] a = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1')
            a[i] = 1;
            else
            a[i] = -1;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ps = 0;
        int ans = 0;
        for(int i = 0; i < a.length; i++){
            ps += a[i];
            ans += map.getOrDefault(ps , 0);
            map.put(ps , map.getOrDefault(ps , 0)+1);
        }
        return ans;*/
        int pg = 0;
        int cg = 1;
        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))
            cg++;
            else{
                ans += Math.min(pg , cg);
                pg = cg;
                cg = 1;
            }
        }
        ans += Math.min(pg , cg);
        return ans;
    }
}