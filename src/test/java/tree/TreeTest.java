package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    private Node node;
    private Tree tree;

    @Before
    public void init(){
        node = new Node(5);
        tree = new Tree(node);
    }

    @Test
    public void testInsertNodeLeftNotNull(){
        int valueInsert = 2;
        tree.insertNode(node, new Node(valueInsert));
        assertNotNull(node.getLeft());
    }

    @Test
    public void testInsertNodeRightNotNull(){
        int valueInsert = 8;
        tree.insertNode(node, new Node(valueInsert));
        assertNotNull(node.getRight());
    }

    @Test
    public void testGetRootIsNotNull(){
        assertNotNull(tree.getRoot());
    }

    @Test
    public void testCompareNumbersIsTrue(){
        int value1 = 3;
        int value2 = 6;
        assertEquals(true, tree.compareNumbers(value1, value2));
    }

    @Test
    public void testCompareNumbersIsFalse(){
        int value1 = 4;
        int value2 = 1;
        assertEquals(false, tree.compareNumbers(value1, value2));
    }



}