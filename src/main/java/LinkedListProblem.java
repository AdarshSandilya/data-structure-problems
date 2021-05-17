import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LinkedListProblem {

    public static int[] solution(int area) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(area>0){
            int closestSquare = (int) Math.floor(Math.sqrt(area));
            closestSquare = closestSquare *closestSquare;
            result.add(closestSquare);
            area = area - closestSquare;
        }
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            ans[i]=  result.get(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private  static int getMaxSquareOf(int number, int start, int end){
        int mid = (start+end)/2;
        int midSquare = mid*mid;
        if(end-start ==1 || start-end ==1){
            if((mid+1) * (mid+1) <=number)
                return (mid+1) * (mid+1);
            return midSquare;
        }
        if(midSquare > number){
            return getMaxSquareOf(number, start, mid);
        }
        else if(midSquare < number){
            return getMaxSquareOf(number, mid, end);
        }
        else return midSquare;
    }

    public int findMiddle(CustomLinkedList list) {
        CustomLinkedList.Node pointer1 = list.head;
        CustomLinkedList.Node pointer2 = list.head;
        while (pointer2.next != null) {
            pointer2 = pointer2.next;
            if (pointer2.next != null) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            if (pointer2.next == null)
                return pointer1.value;
        }
        return pointer1.value;
    }
    
    public CustomLinkedList.Node reverseEveryKNode(CustomLinkedList.Node head, int k){
        if(head == null) return null;
        CustomLinkedList.Node curr = head;
        CustomLinkedList.Node prev = null;
        CustomLinkedList.Node next = null;
        int count = 0;
        while(count <=k &&  curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =  next;
            count++;
        }
        if (next != null){
            head.next =  reverseEveryKNode(next, k);
        }
        return prev;
    }
    
    public CustomLinkedList.Node reverseList(CustomLinkedList.Node  head){
        CustomLinkedList.Node currentNode = head;
        CustomLinkedList.Node previousNode = null;
        while (currentNode != null){
            CustomLinkedList.Node tmp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = tmp;
        }
        return previousNode;
        
    }
    
    public CustomLinkedList.Node removeDuplicateFromList(CustomLinkedList.Node head){
        CustomLinkedList.Node currentNode =  head;
        CustomLinkedList.Node tail =  currentNode;
        while(tail != null){
            if (tail.value != tail.next.value)
                tail = tail.next;
        }
        return currentNode;
    }

    public void deleteMiddleOfList(CustomLinkedList.Node head) {
        CustomLinkedList.Node previousOfMiddle = head;
        CustomLinkedList.Node nextOfMiddle = head;
        CustomLinkedList.Node pointer1 = head;
        CustomLinkedList.Node pointer2 = head;
        while (pointer2.next != null) {
            pointer2 = pointer2.next;
            if (pointer2.next != null) {
                previousOfMiddle = pointer1;
                pointer1 = pointer1.next;
                nextOfMiddle = pointer1.next;
                pointer2 = pointer2.next;
            }
            if (pointer2.next == null)
                break;
        }
        System.out.println(previousOfMiddle.value + "-------");
        System.out.println(nextOfMiddle.value + "----=====---");

    }

    public CustomLinkedList.Node flattenLinkedList(CustomLinkedList.Node listHead) {
        if (listHead == null) return null; // or listHead
        Stack<CustomLinkedList.Node> stack = new Stack<>();
        CustomLinkedList.Node node = listHead;
        while (node != null) {
            if (node.value < 0) {
                int sum = node.value;
                while (!stack.isEmpty()) {
                    CustomLinkedList.Node temp = stack.pop();
                    sum -= temp.value;
                    temp = null;
                    if (sum == 0) {
                        node = stack.peek();
                        break;
                    }
                }
            } else {
                stack.push(node);
            }
            node = node.next;
        }

        return listHead;
    }

    public CustomLinkedList.Node mergeTwoSortedList(CustomLinkedList.Node list1Head, CustomLinkedList.Node list2Head) {
        CustomLinkedList.Node headA = list1Head;
        CustomLinkedList.Node headB = list2Head;

        CustomLinkedList.Node dummyNode = new CustomLinkedList.Node(0);
        CustomLinkedList.Node tail = dummyNode;

        while (true) {
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }
            if (headA.value > headB.value) {
                tail.next = headB;
                headB = headB.next;
            } else {
                tail.next = headA;
                headA = headA.next;
            }
            tail = tail.next;
        }

        return dummyNode.next;
    }
}
