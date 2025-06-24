class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0)
        return new int[]{};
        int s = 0;
        for(int i = 0; i < changed.length; i++){
            s += changed[i];
        }
        if(s%3 != 0)
        return new int[]{};
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < changed.length; i++){
            map.put(changed[i] , map.getOrDefault(changed[i] , 0)+1);
        }
        Arrays.sort(changed);
        List<Integer> ansl = new ArrayList<>();
        for(int i = 0; i < changed.length; i++){
            if(map.get(changed[i]) != 0){
                if(!map.containsKey(2*changed[i]))
                return new int[]{};
                map.put(changed[i] , map.get(changed[i])-1);
                ansl.add(changed[i]);
                map.put(2*changed[i] , map.get(2*changed[i])-1);
            }
        }
        if(ansl.size() != changed.length/2)
        return new int[]{};
        int[] ans = new int[ansl.size()];
        for(int i = 0; i < ansl.size(); i++){
            ans[i] = ansl.get(i);
        }
        return ans;
    }
}