class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int log = (int)(Math.log(k)/Math.log(2))+1;
        int[][] ancestors = new int[receiver.size()][log+1];
        long[][] s = new long[receiver.size()][log+1];
        for(int[] a : ancestors){
            Arrays.fill(a , -1);
        }
        for(int i = 0; i < receiver.size(); i++){
            ancestors[i][0] = receiver.get(i);
            s[i][0] = receiver.get(i);
        }
        for(int j = 1; j < ancestors[0].length; j++){
            for(int i = 0; i < receiver.size(); i++){
                if(ancestors[i][j-1] != -1){
                    ancestors[i][j] = ancestors[ancestors[i][j-1]][j-1];
                    s[i][j] = s[i][j-1]+s[ancestors[i][j-1]][j-1];
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < receiver.size(); i++){
            long sum = i;
            int node = i;
            for(int j = 0; j < ancestors[0].length; j++){
                if((k&(1L<<j)) > 0 && node != -1){
                    sum += s[node][j];
                    node = ancestors[node][j];
                }
            }
            ans = Math.max(ans , sum);
        }
        return ans;
    }
}