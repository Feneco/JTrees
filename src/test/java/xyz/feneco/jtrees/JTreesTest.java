package xyz.feneco.jtrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JTreesTest {
    private JTrees<Integer> tree;
    public JTreesTest() {
    /*  3
        |__ 1
        |   |__ 4
        |__ 2
        |   |__ 5
        |   |__ 6
        |__ 4
            |__ 7
            |__ 8
            |__ 9
            |__ 10 */
        tree = new JTrees<>(3);
            JTrees<Integer> t1 = tree.addChild(1);
                t1.addChild(4);
            JTrees<Integer> t2 = tree.addChild(2);
                t2.addChild(5);
                t2.addChild(6);
            JTrees<Integer> t3 = tree.addChild(4);
                t3.addChild(7);
                t3.addChild(8);
                t3.addChild(9);
                t3.addChild(10);
    }

    @Test
    void levelTest() {
        Assertions.assertEquals(0, tree.getLevel());
        JTrees<Integer> t2 = tree.getChildren(1);
        Assertions.assertEquals(1, t2.getLevel());
        JTrees<Integer> t11 = tree.getChildren(0).getChildren(0);
        Assertions.assertEquals(2, t11.getLevel());
        JTrees<Integer> t32 = tree.getChildren(2).getChildren(2);
        Assertions.assertEquals(2, t32.getLevel());
    }

    @Test
    void isLeafTest() {
        Assertions.assertFalse(tree.isLeaf());
        JTrees<Integer> t1 = tree.getChildren(0).getChildren(0);
        Assertions.assertTrue(t1.isLeaf());
    }

    @Test
    void isRootTest() {
        Assertions.assertTrue(tree.isRoot());
        Assertions.assertFalse(tree.getChildren(0).isRoot());
    }

    @Test
    void getParentTest(){
        JTrees<Integer> t1 = tree.getChildren(0);
        JTrees<Integer> t2 = tree.getChildren(1);
        Assertions.assertEquals(t1.getParent(), tree);
        Assertions.assertEquals(t2.getParent(), tree);
    }

    @Test
    void getTest(){
        Assertions.assertEquals(3, tree.getData());
        Assertions.assertNotEquals(4, tree.getData());
    }
}
