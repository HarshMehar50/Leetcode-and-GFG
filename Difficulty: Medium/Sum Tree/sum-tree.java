/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    int sum(Node root){
        if(root == null)
        return 0;
        return root.data+sum(root.left)+sum(root.right);
    }
    boolean solve(Node root){
        if(root == null || (root.left == null && root.right == null))
        return true;
        if((root.data == sum(root.left)+sum(root.right))&&solve(root.left)&&solve(root.right))
        return true;
        else
        return false;
    }
    boolean isSumTree(Node root) {
        // Your code here
        return solve(root);
    }
}