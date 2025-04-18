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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*   HashMap<Integer , Integer> map = new HashMap<>();
    for(int i=0; i < inorder.length; i++) {
    map.put(inorder[i], i);
     }

    int[] index = {0};

    return helper(preorder, inorder, 0, preorder.length-1, map, index);
}
    public TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map, int[] index) {
    if (left > right) {
      return null;
    }

    int current = preorder[index[0]];
    index[0]++;

    TreeNode node = new TreeNode(current);

    if (left == right) {
      return node;
    }

    node.left = helper(preorder, inorder, left, index-1, map, index);
    node.right = helper(preorder, inorder, index+1, right, map, index);

    return node;*/
        if (preorder.length == 0) {
            return null;
        }
        int r = preorder[0];
        int index = 0;
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == r) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }
}