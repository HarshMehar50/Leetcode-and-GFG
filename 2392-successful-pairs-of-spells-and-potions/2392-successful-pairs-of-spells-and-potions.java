class Solution {
    int floor(int[] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s < e){
            int m = s+(e-s)/2;
            if(a[m] < x)
            s = m+1;
            else
            e = m;
        }
        return s;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < ans.length; i++){
            if((long)((long)potions[potions.length-1]*(long)spells[i]) < success) continue;
            long req = success/spells[i];
            if(success%spells[i] != 0)
            req++;
            int f = floor(potions , (int)req);
            /*if(f == potions.length-1){
                if((long)((long)potions[potions.length-1]*(long)spells[i]) < success)
                f++;
            }*/
            ans[i] = potions.length-f;
        }
        return ans;
    }
}