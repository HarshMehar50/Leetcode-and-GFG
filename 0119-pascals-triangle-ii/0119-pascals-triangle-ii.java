class Solution {
    public List<Integer> getRow(int rowIndex) {
        /*int[] f = new int[rowIndex+1];
        f[0] = 1;
        for(int i = 1; i < f.length; i++){
            f[i] = f[i-1]*i;
        }*/
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex == 0)
        return ans;
        ans.add(rowIndex);
        if(rowIndex == 1)
        return ans;
        long v = rowIndex;
        for(int i = 2; i <= rowIndex/2; i++){
            v = v*(rowIndex-i+1)/i;
            ans.add((int)v);
        }
        if(rowIndex%2 == 1){
            for(int i = rowIndex/2; i >= 0; i--){
                ans.add(ans.get(i));
            }
        }else{
            for(int i = rowIndex/2-1; i >= 0; i--){
                ans.add(ans.get(i));
            }
        }
        return ans;
    }
}