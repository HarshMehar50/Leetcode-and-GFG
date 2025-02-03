class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score , (x , y)->Integer.compare(y[k] , x[k]));
        return score;
    }
}