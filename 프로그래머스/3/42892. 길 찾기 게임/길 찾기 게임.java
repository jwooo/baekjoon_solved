import java.util.*;

class Solution {
    
    static List<Integer> preOrderNodes = new ArrayList<>();
    static List<Integer> postOrderNodes = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        
        Collections.sort(nodes);
        Tree tree = new Tree(nodes.get(0));
        
        for (int i = 1; i < nodes.size(); i++) {
            tree.add(nodes.get(i));
        }
        
        tree.preOrder(nodes.get(0));
        tree.postOrder(nodes.get(0));
        
        int[] preNodes = preOrderNodes.stream().mapToInt(Integer::intValue).toArray();
        int[] postNodes = postOrderNodes.stream().mapToInt(Integer::intValue).toArray();
        
        answer[0] = preNodes;
        answer[1] = postNodes;
        
        return answer;
    }
    
    static class Tree {
        Node root;
        
        public Tree(Node root) {
            this.root = root;
        }
        
        public void add(Node insertNode) {
            if (this.root == null) {
                root = insertNode;
                return;
            }
            
            addNode(root, insertNode);
        }
        
       	private Node addNode(Node node, Node insertNode) {
            if (node == null) {
                return insertNode;
            }
         
            if (insertNode.y < node.y && insertNode.x < node.x) {
                node.left = addNode(node.left, insertNode);
            } else if (insertNode.y < node.y && insertNode.x > node.x) {
                node.right = addNode(node.right, insertNode);
            }
            
            return node;
        }
        
        private void preOrder(Node node) {
            if (node == null) {
                return;
            }
            
            preOrderNodes.add(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
        
        private void postOrder(Node node) {
            if (node == null) return;
            
            postOrder(node.left);
            postOrder(node.right);
            postOrderNodes.add(node.value);
        }
    }
    
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) return o.y - this.y;
            return this.x - o.x;
        }
        
        @Override
        public String toString() {
            return "Node {x=" + x + ", y=" + y + ", value=" + value + ", left=" + left + ", right=" + right + "}";
        }
    }
}