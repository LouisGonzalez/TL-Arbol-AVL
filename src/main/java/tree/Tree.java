package tree;

public class Tree {

    private Node firstNode;
    private Node root;

    public Tree(Node firstNode){
        this.firstNode = firstNode;
        root = this.firstNode;
    }


    public void insertNode(Node father, Node toInsert){
        boolean compare = compareNumbers(father.getValue(), toInsert.getValue());
        if(compare){
            if(father.getRight() != null)
                insertNode(father.getRight(), toInsert);
            else
                father.setRight(toInsert);
        } else {
            if(father.getLeft() != null)
                insertNode(father.getLeft(), toInsert);
            else
                father.setLeft(toInsert);
        }
        setNewLevel(father);
        setNewBalance(father);
    }

    public boolean compareNumbers(int valueFather, int valueInsert){
        if(valueFather < valueInsert){
            return true;
        }
        return false;
    }

    public void setNewLevel(Node actual){
        Integer valueLeft = null;
        Integer valueRight = null;
        if(actual.getLeft() != null) valueLeft = actual.getLeft().getLevel();
        if(actual.getRight() != null) valueRight = actual.getRight().getLevel();
        actual.setLevel(compareLevels(valueLeft, valueRight));
    }

    public Integer compareLevels(Integer left, Integer right){
        if(left != null && right != null){
            if(left > right){
                return left + 1;
            }
        } else {
            if(left == null) return right + 1;
            else if(right == null) return left + 1;
        }
        return right + 1;
    }

    public void setNewBalance(Node actual){
        Integer levelLeft = null;
        Integer levelRight = null;
        if(actual.getLeft() != null) levelLeft = actual.getLeft().getLevel();
        if(actual.getRight() != null) levelRight = actual.getRight().getLevel();
        int newBalance = calculateBalanceNode(levelLeft, levelRight);
        actual.setBalance(newBalance);
        if(actual.getBalance() >= 2){
            trasladeRightBalance(actual);
            modifyLevelsAndBalances(actual);
        } else if(actual.getBalance() <= -2){
            //System.out.println("el nodo que quiero reemplazar: "+actual.getValue());
            trasladeLeftBalance(actual);
            //System.out.println("el nodo que despues reemplazar: "+actual.getValue());
            modifyLevelsAndBalances(actual);
        }
    }

    public Integer calculateBalanceNode(Integer left, Integer right){
        if(left == null) return right;
        if(right == null) return -left;
        return right - left;
    }

    public void modifyLevelsAndBalances(Node actual){
        if(actual.getLeft() != null){
            modifyLevelsAndBalances(actual.getLeft());
        }
        if(actual.getRight() != null){
            modifyLevelsAndBalances(actual.getRight());
        }
        if(actual.getLeft() == null && actual.getRight() == null){
            actual.setLevel(1);
            actual.setBalance(0);
        } else {
            Integer levelLeft = null, levelRight = null;
            if(actual.getLeft() != null) levelLeft = actual.getLeft().getLevel();
            if(actual.getRight() != null) levelRight = actual.getRight().getLevel();
            actual.setLevel(this.compareLevels(levelLeft, levelRight));
            actual.setBalance(this.calculateBalanceNode(levelLeft, levelRight));

        }
    }

    public void printTree(Node actual){
        System.out.println("Nodo padre: "+actual.getValue()+" Nivel: "+actual.getLevel()+" Balance: "+actual.getBalance());
        if(actual.getLeft() != null) System.out.println("Nodo izquierdo: "+actual.getLeft().getValue()+" Nivel: "+actual.getLeft().getLevel()+" Balance: "+actual.getLeft().getBalance());
        if(actual.getRight() != null) System.out.println("Nodo derecho: "+actual.getRight().getValue()+" Nivel: "+actual.getRight().getLevel()+" Balance: "+actual.getRight().getBalance());
        System.out.println("");
        if(actual.getLeft() != null){
            printTree(actual.getLeft());
        }
        if(actual.getRight() != null){
            printTree(actual.getRight());
        }
    }

    public String printTree2(Node actual, boolean father){
        String text = "";
        for (int i = 0; i < actual.getLevel(); i++) {
            text += " ";
        }
        if(father) text += actual.getValue();
        String s1 = "", s2 = "";
        if(actual.getLeft() != null){
            for (int i = 0; i < actual.getLeft().getLevel(); i++) {
                s1 += " ";
            }
            s1 += actual.getLeft().getValue();
        }
        if(actual.getRight() != null){
            for (int i = 0; i < actual.getRight().getLevel(); i++) {
                s2 += " ";
            }
            s2 += actual.getRight().getValue();
        }
        String sons = s1 + s2;
        text += "\n"+ sons;
        if(actual.getLeft() != null){
            text += printTree2(actual.getLeft(), false);
        }
        if(actual.getRight() != null){
            text += printTree2(actual.getRight(), false);
        }
        return text;
    }

    /*FUNCIONALIDADES ARBOL AVL*/
    public void trasladeRightBalance(Node actual){  //balance >=2
        Node aux = new Node(actual.getValue());
        aux.setRight(actual.getRight().getLeft());
        aux.setLeft(actual.getLeft());
        actual.setValue(actual.getRight().getValue());
        actual.setRight(actual.getRight().getRight());
        actual.setLeft(aux);

    }

    public void trasladeLeftBalance(Node actual){   //balance <=2
        Node aux = new Node(actual.getValue());
        aux.setLeft(actual.getLeft().getRight());
        aux.setRight(actual.getRight());
        actual.setValue(actual.getLeft().getValue());
        actual.setLeft(actual.getLeft().getLeft());
        actual.setRight(aux);
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public int getLevel(){
        return 0;
    }
}
