class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] a1 = new int[security.length];
        int[] a2 = new int[security.length];
        //Arrays.fill(a1 , 1);
        //Arrays.fill(a2 , 1);
        for(int i = 1; i < a1.length; i++){
            if(security[i-1] >= security[i])
            a1[i] = a1[i-1]+1;
        }
        for(int i = a2.length-2; i >= 0; i--){
            if(security[i+1] >= security[i])
            a2[i] = a2[i+1]+1;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = time; i < security.length-time; i++){
            if(a1[i] >= time && a2[i] >= time)
            ans.add(i);
        }
        return ans;
    }
}