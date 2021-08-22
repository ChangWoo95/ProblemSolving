package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KaKao2019_길찾기게임 {
    List<Integer> nodesUsingPreOrder;
    List<Integer> nodesUsingPostOrder;

    class Tree {
        public Node root;

        public void setRoot(Node node) {
            this.root = node;
        }

        public void addNode(Node node){
            if(this.root == null) setRoot(node);
            else {
                Node curNode = this.root;
                Node prevNode = null;

                while(curNode != null) {
                    prevNode = curNode;
                    if(curNode.x > node.x) curNode = curNode.left;
                    else curNode = curNode.right;
                }
                if(prevNode.x < node.x) prevNode.right = node;
                else prevNode.left = node;
            }
            return;
        }

        public void preOrder(Node node) {
            if(node == null ) return;
            nodesUsingPreOrder.add(node.idx);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void postOrder(Node node) {
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            nodesUsingPostOrder.add(node.idx);
        }
    }

    class Node implements Comparable<Node> {
        int x,y;
        int idx;
        Node left, right;

        Node(int x,int y,int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(node.y, this.y);
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];

        PriorityQueue<Node> pq = makePrioriryQueue(nodeinfo);
        Tree tree = makeTree(pq);

        Node root = tree.root;
        nodesUsingPreOrder = new ArrayList<>();
        tree.preOrder(root);
        answer[0] = nodesUsingPreOrder.stream().mapToInt(Integer::intValue).toArray();

        nodesUsingPostOrder = new ArrayList<>();
        tree.postOrder(root);
        answer[1] = nodesUsingPostOrder.stream().mapToInt(Integer::intValue).toArray();

        return answer;

    }

    public Tree makeTree(PriorityQueue<Node> pq) {
        Tree ret = new Tree();
        while(!pq.isEmpty()) {
            ret.addNode(pq.poll());
        }
        return ret;
    }

    public PriorityQueue<Node> makePrioriryQueue(int[][] nodeinfo) {
        PriorityQueue<Node> ret = new PriorityQueue<>();
        for(int i =0; i < nodeinfo.length; ++i) {
            int[] nodePos = nodeinfo[i];
            ret.offer(new Node(nodePos[0], nodePos[1], i+1));
        }
        return ret;
    }
}