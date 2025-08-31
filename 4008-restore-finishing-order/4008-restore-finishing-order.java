class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int max = 0;
        for(int i = 0; i < friends.length; i++){
            max = Math.max(friends[i] , max);
        }
        boolean[] present = new boolean[max+1];
        for(int i = 0; i < friends.length; i++){
            present[friends[i]] = true;
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < order.length; i++){
            if(order[i] <= max && present[order[i]])
                l.add(order[i]);
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}