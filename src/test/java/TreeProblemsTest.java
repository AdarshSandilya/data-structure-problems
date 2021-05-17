import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TreeProblemsTest {

    private TreeProblems treeProblems;

    @BeforeEach
    void setUp(){
        treeProblems = new TreeProblems();
    }


    @Test
    void test_BSTtoList() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode head = new TreeNode(0);
        TreeNode prev = new TreeNode(0);
        
        treeProblems.BSTtoList(root, head, prev);
        System.out.println(head.value);
        System.out.println(head.right.value);
        System.out.println(head.right.left.value);
    }

    @Test
    void test_dfsInorder() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        ArrayList<Integer> path = new ArrayList<>();
        treeProblems.dfsInorder(root, path);
    }

    @Test
    void test_findPath(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        ArrayList<Integer> path = new ArrayList<>();
        treeProblems.hasPath(root, 6, path);
        System.out.println(path+"===");
    }
    @Test
    void test_printEveryNodeBFS() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        treeProblems.printEveryNodeBFS(root);
    }

    @Test
    void test_isValidBST() {
        TreeNode root = new TreeNode(5);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(8);
        TreeNode node1 = new TreeNode(0);
        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = node1;

        boolean res = treeProblems.isValidBST(root);
        assertTrue(res);
    }
}