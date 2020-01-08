import java.util.*;
public class Main {
    static class Node{
        int value;
        Node left, right;

        public int getValue(){
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class Tree{
        Node root;

        public void addNode(int value){
            if (root == null) {
                Node node = new Node();
                node.setValue(value);
                root = node;
            } else {
                addNode(value, root);
            }
        }

        public void addNode(int value, Node root) {
            if (value <= root.getValue()) {
                if (root.getLeft() == null) {
                    Node node = new Node();
                    node.setValue(value);
                    root.setLeft(node);
                } else {
                    addNode(value, root.getLeft());
                }
            } else {
                if (root.getRight() == null) {
                    Node node = new Node();
                    node.setValue(value);
                    root.setRight(node);
                } else {
                    addNode(value, root.getRight());
                }
            }
        }

        public void printTree() {
            postorder(root);
        }

        public void postorder(Node root) {
            if (root != null) {
                postorder(root.getLeft());
                postorder(root.getRight());
                System.out.println(root.getValue());
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        Tree tree = new Tree();

        while (sc.hasNextLine() && !(str = sc.nextLine()).equals("")) {
            tree.addNode(Integer.parseInt(str));
        }

        tree.printTree();
    }
}
