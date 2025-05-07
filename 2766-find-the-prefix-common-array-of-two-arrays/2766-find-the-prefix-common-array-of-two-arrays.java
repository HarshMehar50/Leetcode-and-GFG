class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        HashMap<Integer , Integer> mapA = new HashMap<>();
        HashMap<Integer , Integer> mapB = new HashMap<>();
        for(int i = 1; i <= A.length; i++){
            mapA.put(i , 0);
            mapB.put(i , 0);
        }
        for(int i = 0; i < A.length; i++){
            int va = mapA.get(A[i]);
            int vb = mapB.get(B[i]);
            mapA.put(A[i] , va+1);
            mapB.put(B[i] , vb+1);
            for(int j = 1; j <= A.length; j++){
                if(mapA.get(j) == 1 && mapB.get(j) == 1)
                    ans[i]++;
            }
        }
        return ans;
    }
}