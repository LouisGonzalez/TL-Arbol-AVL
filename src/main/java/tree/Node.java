package tree;

public class Node {

    private Integer value;
    private Integer level = 1;
    private Integer balance = 0;

    private Node left = null;
    private Node right = null;

    public Node(Integer value){
        this.value = value;
    }

    public Node(){}

    public Integer getValue() {
        return value;
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

    public Integer getLevel(){
        return this.level;
    }

    public void setLevel(Integer level){
        this.level = level;
    }

    public Integer getBalance(){
        return this.balance;
    }

    public void setBalance(Integer balance){
        this.balance = balance;
    }
}
