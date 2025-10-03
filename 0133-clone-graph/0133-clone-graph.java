/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    void DFS(Node cloneNode , Node node , HashMap<Node , Node> map){
        for(Node x : node.neighbors){
            if(!map.containsKey(x)){
                Node clone = new Node(x.val);
                map.put(x , clone);
                cloneNode.neighbors.add(clone);
                DFS(clone , x , map); 
            }else
            cloneNode.neighbors.add(map.get(x));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null)
        return null;
        Node cloneNode = new Node(node.val);
        HashMap<Node , Node> map = new HashMap<>();
        map.put(node , cloneNode);
        DFS(cloneNode , node , map);
        return cloneNode;
    }
}