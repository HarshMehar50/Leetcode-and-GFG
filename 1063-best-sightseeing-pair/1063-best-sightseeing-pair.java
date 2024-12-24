class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        if(values.length == 2)
        return values[0]+values[1]-1;
        int[] a1 = new int[values.length];
        int[] a2 = new int[values.length];
        for(int i = 0; i < a1.length; i++){
            a1[i] = values[i]+i;
            a2[i] = values[i]-i;
        }
        int[] p = new int[values.length];
        p[values.length-1] = Integer.MIN_VALUE;
        for(int i = values.length-2; i >= 0; i--){
            p[i] = Math.max(p[i+1] , a2[i+1]);
        }
        int ans = 0;
        for(int i = 0; i < a1.length-1; i++){
            ans = Math.max(a1[i]+p[i] , ans);
        }
        return ans;
    }
}