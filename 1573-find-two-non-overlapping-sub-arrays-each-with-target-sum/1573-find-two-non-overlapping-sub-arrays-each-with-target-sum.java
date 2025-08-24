class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] psl = new int[arr.length];
        HashMap<Integer , Integer> pmap = new HashMap<>();
        int ps = 0;
        pmap.put(0 , -1);
        for(int i = 0; i < arr.length; i++){
            ps += arr[i];
            int req = ps-target;
            int l = Integer.MAX_VALUE;
            if(pmap.containsKey(req))
            l = i-pmap.get(req);
            psl[i] = l;
            pmap.put(ps , i);
        }
        int[] ssl = new int[arr.length];
        HashMap<Integer , Integer> smap = new HashMap<>();
        int ss = 0;
        smap.put(0 , arr.length);
        for(int i = arr.length-1; i >= 0; i--){
            ss += arr[i];
            int req = ss-target;
            int l = Integer.MAX_VALUE;
            if(smap.containsKey(req))
            l = smap.get(req)-i;
            ssl[i] = l;
            smap.put(ss , i);
        }
        for(int i = 1; i < arr.length; i++){
            psl[i] = Math.min(psl[i-1] , psl[i]);
        }
        for(int i = arr.length-2; i >= 0; i--){
            ssl[i] = Math.min(ssl[i] , ssl[i+1]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(psl[i-1] != Integer.MAX_VALUE && ssl[i] != Integer.MAX_VALUE)
            ans = Math.min(ans , psl[i-1]+ssl[i]);
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        else
        return -1;
    }
}