class Solution {
    int ceil(List<Integer> list , int k){
        int s = 0;
        int e = list.size()-1;
        while(s <= e){
            int m = s + (e-s)/2;
            if(list.get(m) == k){
                return m;
            }
            if(list.get(m) > k){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return s;
    }
    int solveBinary(int[] a){
        List<Integer> ans = new ArrayList<>();
        ans.add(a[0]);
        for(int i = 1; i < a.length; i++){
            if(a[i] > ans.get(ans.size()-1))
            ans.add(a[i]);
            else{
                int index = ceil(ans, a[i]);
                ans.remove(index);
                ans.add(index , a[i]);
            }
        }
        return ans.size();
    }
    public int maxEnvelopes(int[][] envelopes) {
        //Arrays.sort(envelopes , (a , b) -> Integer.compare(a[0] , b[0]));
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for(int i = 0; i < envelopes.length-1; i++){
            if(envelopes[i][0] == envelopes[i+1][0]){
                envelopes[i][1] = Math.max(envelopes[i][1] , envelopes[i+1][1]);
                envelopes[i+1][1] = Math.min(envelopes[i][1] , envelopes[i+1][1]);
            }
        }
        int[] a = new int[envelopes.length];
        for(int i = 0; i < a.length; i++){
            a[i] = envelopes[i][1];
        }
        return solveBinary(a);
    }
}