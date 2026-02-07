class Solution {
    void permutations(int n , boolean[] used , List<List<Integer>> ans , List<Integer> inner , int i){
        if(i == n){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int j = 0; j < n; j++){
            if(!used[j]){
                used[j] = true;
                inner.add(j);
                permutations(n , used , ans , inner , i+1);
                inner.remove(inner.size()-1);
                used[j] = false;
            }
        }
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        boolean[] used = new boolean[students.length];
        permutations(students.length , used , ans , inner , 0);
        int fans = 0;
        for(List<Integer> l : ans){
            int s = 0;
            for(int i = 0; i < l.size(); i++){
                for(int j = 0; j < students[0].length; j++){
                    s += ((students[l.get(i)][j]^mentors[i][j])+1)%2;
                }
            }
            fans = Math.max(fans , s);
        }
        return fans;
    }
}