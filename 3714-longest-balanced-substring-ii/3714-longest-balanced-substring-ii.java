class Solution {
    int case1(String s){
        int ans = 0;
        for(char ch = 'a'; ch <= 'c'; ch++){
            int maxs = 0;
            int rs = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ch)
                rs++;
                else{
                    maxs = Math.max(maxs , rs);
                    rs = 0;
                }
            }
            maxs = Math.max(maxs , rs);
            ans = Math.max(ans , maxs);
        }
        return ans;
    }
    int case2(String s , char[] c){
        int[] a = new int[s.length()];
        for(int i = 0; i < a.length; i++){
            if(s.charAt(i) == c[0])
            a[i] = -1;
            else if(s.charAt(i) == c[1])
            a[i] = 1;
            else
            a[i] = 4*a.length;
        }
        int ps = 0;
        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        for(int i = 0; i < a.length; i++){
            ps += a[i];
            if(map.containsKey(ps))
            ans = Math.max(ans , i-map.get(ps));
            else
            map.put(ps , i);
        }
        return ans;
    }
    
    int case3(String s){
        HashMap<String , Integer> map = new HashMap<>();
        int[] f = new int[3];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            f[s.charAt(i)-'a']++;
            if(f[0] == f[1] && f[1] == f[2])
            ans = Math.max(ans , f[0]*3);
            String key = (f[0]-f[1])+" "+(f[1]-f[2]);
            if(map.containsKey(key))
            ans = Math.max(ans , i-map.get(key));
            else
            map.put(key , i);
        }
        return ans;
    }
    public int longestBalanced(String s) {
        int c1 = case1(s);
        int c2 = Math.max(case2(s , new char[]{'a' , 'b'}) , Math.max(case2(s , new char[]{'b' , 'c'}) , case2(s , new char[]{'a' , 'c'})));
        int c3 = case3(s);
        return Math.max(c1 , Math.max(c2 , c3));
    }
}