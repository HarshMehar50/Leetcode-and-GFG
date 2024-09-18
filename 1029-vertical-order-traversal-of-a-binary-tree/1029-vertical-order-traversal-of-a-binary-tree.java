/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class node{
    TreeNode tree;
    int r;
    int c;
    public node(TreeNode tree , int r , int c){
        this.tree = tree;
        this.r = r;
        this.c = c;
    }
} 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       /* List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        int c = 0;
        Queue<Map.Entry<TreeNode , Integer>> q = new ArrayDeque<>();
        Map<Integer , ArrayList<Integer>> map = new HashMap<>();
        q.offer(new AbstractMap.SimpleEntry<>(root , c));
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            Map.Entry<TreeNode , Integer> removed = q.poll();
            root = removed.getKey();
            c = removed.getValue();
            if(root != null){
                if(!map.containsKey(c)){
                    map.put(c , new ArrayList<Integer>());
                }
                map.get(c).add(root.val);
                min = Math.min(min , c);
                max = Math.max(max , c);
                q.offer(new AbstractMap.SimpleEntry<>(root.left , c-1));
                q.offer(new AbstractMap.SimpleEntry<>(root.right , c+1));
            }
        }
        for(int i = min; i <= max; i++){
            list.add(map.get(i));
        }
        return list;*/
       /* List<int[]> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Map.Entry<TreeNode , int[]>> q = new LinkedList<>();
        int r = 0;
        q.offer(new AbstractMap.SimpleEntry<>(root , new int[]{0 , r}));
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                TreeNode cnode = q.peek().getKey();
                int cr = q.peek().getValue()[1];
                int c = q.peek().getValue()[0];
                ans.add(new int[]{cr, c , cnode.val});
                q.poll();
                if(cnode.left != null){
                    q.offer(new AbstractMap.SimpleEntry<>(cnode.left , new int[]{c-1 , cr+1}));
                }
                if(cnode.right != null){
                    q.offer(new AbstractMap.SimpleEntry<>(cnode.right , new int[]{c+1 , cr+1}));
                }
            }
            r++;
        }
        int[][] a = new int[ans.size()][3];
        for(int i = 0; i < a.length; i++){
            a[i] = ans.get(i);
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = a[0][0]; i <= a[a.length-1][0]; i++){
            map.put(i , new ArrayList<>());
        }
        for(int i = 0; i < a.length; i++){
            map.get(a[i][0]).add(a[i][2]);
        }
        for(int i = a[0][0]; i <= a[a.length-1][0]; i++){
            result.add(map.get(i));
        }
        return result;*/
        if(root == null){
            return new ArrayList<>();
        }
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<node> q = new LinkedList<>();
        q.offer(new node(root , 0 , 0));
        while(!q.isEmpty()){
            TreeNode cnode = q.peek().tree;
            int cc = q.peek().c;
            int cr = q.peek().r;
            q.poll();
            map.putIfAbsent(cc , new TreeMap<>());
            map.get(cc).putIfAbsent(cr , new PriorityQueue<>());
            map.get(cc).get(cr).offer(cnode.val);
            if(cnode.left != null){
                q.offer(new node(cnode.left , cr+1 , cc-1));
            }
            if(cnode.right != null){
                q.offer(new node(cnode.right , cr+1 , cc+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> t : map.values()){
            List<Integer> inner = new ArrayList<>();
            for(PriorityQueue<Integer> pq : t.values()){
                while(!pq.isEmpty()){
                    inner.add(pq.poll());
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}