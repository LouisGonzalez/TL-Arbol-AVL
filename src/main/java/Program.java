import tree.Node;
import tree.Tree;

public class Program {



    public static void main(String[] args){
        Node root = new Node(6);
        Tree tree = new Tree(root);
        tree.insertNode(tree.getRoot(), new Node(4));
        tree.insertNode(tree.getRoot(), new Node(1));
        tree.insertNode(tree.getRoot(), new Node(2));
        tree.insertNode(tree.getRoot(), new Node(12));
        tree.insertNode(tree.getRoot(), new Node(5));
        tree.insertNode(tree.getRoot(), new Node(13));
        tree.insertNode(tree.getRoot(), new Node(15));
        tree.insertNode(tree.getRoot(), new Node(18));
        tree.printTree(tree.getRoot());
        System.out.println(tree.printTree2(tree.getRoot(), true));

    }

}
