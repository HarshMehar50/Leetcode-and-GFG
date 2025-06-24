/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    int solve(Node node , int l , int h){
        if(node == null)
        return 0;
        if(node.data >= l && node.data <= h)
        return 1+solve(node.left , l , h)+solve(node.right , l , h);
        else if(node.data < l)
        return solve(node.right , l , h);
        else
        return solve(node.left , l , h);
    }
    int getCount(Node root, int l, int h) {
        // Your code here
        return solve(root , l , h);
    }
}