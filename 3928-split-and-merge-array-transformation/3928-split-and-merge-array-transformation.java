class Solution {
    class Pair{
        List<Integer> l1;
        int c;
        public Pair(List<Integer> l1 , int c){
            this.l1 = l1;
            this.c = c; 
        }
    }
    List<Integer> insert(List<Integer> t , List<Integer> l , int p){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < p; i++){
            ans.add(l.get(i));
        }
        ans.addAll(t);
        for(int i = p; i < l.size(); i++){
            ans.add(l.get(i));
        }
        return ans;
    }
    public int minSplitMerge(int[] nums1, int[] nums2) {
        Queue<Pair> q = new LinkedList<>();
        List<Integer> il1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> fl2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        Set<String> visited = new HashSet<>();
        visited.add(il1.toString());
        q.offer(new Pair(il1 , 0));
        while(!q.isEmpty()){
            List<Integer> cl1 = q.peek().l1;
            int count = q.peek().c;
            q.poll();
            if(cl1.equals(fl2))
            return count;
            for(int l = 0; l <= cl1.size(); l++){
                for(int i = 0; i+l-1 < cl1.size(); i++){
                    List<Integer> nl1 = new ArrayList<>();
                    List<Integer> temp = new ArrayList<>();
                    for(int j = 0; j < cl1.size(); j++){
                        if(j < i || j > i+l-1)
                        nl1.add(cl1.get(j));
                        else
                        temp.add(cl1.get(j));
                    }
                    for(int j = 0; j <= nl1.size(); j++){
                        List<Integer> nl11 = insert(temp , nl1 , j);
                        if(!visited.contains(nl11.toString())){
                        q.offer(new Pair(nl11 , count+1));
                        visited.add(nl11.toString());
                        }
                    }
                }
            }
        }
        return -1;
    }
}