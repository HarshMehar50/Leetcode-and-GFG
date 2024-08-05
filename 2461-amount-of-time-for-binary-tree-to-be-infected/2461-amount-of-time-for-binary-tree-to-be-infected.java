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
class Solution {
     static void createParentList(TreeNode root , List<Integer> parent){
        if(root == null){
            return;
        }
        parent.add(root.val);
        createParentList(root.left , parent);
        createParentList(root.right , parent);
    }
   static void createAdjList(List<Integer> parent , TreeNode root , HashMap<Integer , List<Integer>> adj){
       /* for(int i = 0; i < parent.size(); i++){
            adj.put(parent.get(i) , new ArrayList<>());
        }*/
       if(root == null){
           return;
       }
        if(root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
        }
        if(root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
        }
        createAdjList(parent , root.left , adj);
       createAdjList(parent , root.right , adj);
   }
   static List<List<Integer>> BFSLevel(HashMap<Integer , List<Integer>> adj , List<Integer> parent , int s){
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer , Boolean> visited = new HashMap<>();
        for(int i = 0; i < parent.size(); i++){
            visited.put(parent.get(i) , false);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited.put(s , true);
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                int c = q.poll();
                inner.add(c);
                for(int j = 0; j < adj.get(c).size(); j++){
                    if(visited.get(adj.get(c).get(j)) == false) {
                        q.offer(adj.get(c).get(j));
                        visited.put(adj.get(c).get(j) , true);
                    }
                }
            }
            list.add(inner);
        }
        return list;
    }
    public int amountOfTime(TreeNode root, int start) {
         List<Integer> parent = new ArrayList<>();
        createParentList(root , parent);
         HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < parent.size(); i++){
            adj.put(parent.get(i) , new ArrayList<>());
        }
        createAdjList(parent , root , adj);
        List<List<Integer>> bfsList = BFSLevel(adj , parent , start);
        return bfsList.size()-1;
    }
}