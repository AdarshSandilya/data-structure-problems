import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemTest {

    private LinkedListProblem listProblems;

    @BeforeEach
    void setUp() {
        listProblems = new LinkedListProblem();
    }

    @Test
    void test_solution() {
        int[] solution = LinkedListProblem.solution(12);
    }

    @Test
    void test_reverseList() {
        CustomLinkedList list = new CustomLinkedList();

        CustomLinkedList.Node node1 = new CustomLinkedList.Node(1);
        CustomLinkedList.Node node2 = new CustomLinkedList.Node(2);
        CustomLinkedList.Node node3 = new CustomLinkedList.Node(3);
        CustomLinkedList.Node node4 = new CustomLinkedList.Node(4);

        node1.next =node2;
        node2.next =node3;
        node3.next =node4;

        CustomLinkedList.Node res = listProblems.reverseList(node1);
        assertEquals(4, res.value);
    }

    @Test
    void test_deleteMiddleOfList() {
        CustomLinkedList list = new CustomLinkedList();

        CustomLinkedList.Node node1 = new CustomLinkedList.Node(1);
        CustomLinkedList.Node node2 = new CustomLinkedList.Node(2);
        CustomLinkedList.Node node3 = new CustomLinkedList.Node(3);
        CustomLinkedList.Node node4 = new CustomLinkedList.Node(4);
        CustomLinkedList.Node node5 = new CustomLinkedList.Node(5);
        CustomLinkedList.Node node6 = new CustomLinkedList.Node(6);
        CustomLinkedList.Node node7 = new CustomLinkedList.Node(7);

        node1.next =node2;
        node2.next =node3;
        node3.next =node4;
        node4.next =node5;
        node5.next =node6;
        node6.next =node7;
        listProblems.deleteMiddleOfList(node1);
    }

    @Test
    void test_find_middle() {
        CustomLinkedList list = new CustomLinkedList();
        
        CustomLinkedList.Node node1 = new CustomLinkedList.Node(1);
        CustomLinkedList.Node node2 = new CustomLinkedList.Node(2);
        CustomLinkedList.Node node3 = new CustomLinkedList.Node(3);
        CustomLinkedList.Node node4 = new CustomLinkedList.Node(4);
        CustomLinkedList.Node node5 = new CustomLinkedList.Node(5);
        
        node1.next =node2;
        node2.next =node3;
        node3.next =node4;
        node4.next =node5;
        
        list.head = node1;
        
        int middle = listProblems.findMiddle(list);
        
        assertEquals(3, middle);
    }

    @Test
    void test_mergeTwoSortedList() {
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList.Node node1 = new CustomLinkedList.Node(2);
        CustomLinkedList.Node node2 = new CustomLinkedList.Node(3);
        CustomLinkedList.Node node3 = new CustomLinkedList.Node(8);
        list1.head = node1;
        node1.next = node2;
        node2.next = node3;
        
        CustomLinkedList list2 = new CustomLinkedList();
        CustomLinkedList.Node node4 = new CustomLinkedList.Node(1);
        CustomLinkedList.Node node5 = new CustomLinkedList.Node(7);
        CustomLinkedList.Node node6 = new CustomLinkedList.Node(5);
        list2.head = node4;
        node4.next = node5;
        node5.next = node6;

        CustomLinkedList.Node res = listProblems.mergeTwoSortedList(node1, node4);
        assertEquals(1, res.value);
        assertEquals(2, res.next.value);
//        assertEquals(2, res.next.next.value);
    }
}