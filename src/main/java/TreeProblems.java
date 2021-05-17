import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeProblems {
    
    public TreeNode convertArrToBST(int[] arr, int start,  int end){
        if(start>end)
            return null;
        int mid =  start+end/2;
        int root_val = arr[mid];
        TreeNode root = new TreeNode(root_val);
        root.left = convertArrToBST(arr, start, mid -1);
        root.right = convertArrToBST(arr, mid +1, end);
        return root;
    }
    
    public void BSTToArr(TreeNode root) {
        if(root == null)
            return ;
        BSTToArr(root.left);
    }
    
    public void BSTtoList(TreeNode node, TreeNode head, TreeNode prev){
        if (node == null)
            return;
        BSTtoList(node.left, head, prev);
        System.out.println(node.value + "====" + head);
        if(prev == null){
           head = node;
        }
        else{
            node.left =  prev;
            prev.right =  node;
        }
        prev = node;
        BSTtoList(node.right, head, prev);
    }
    
    public void dfsInorder(TreeNode node, ArrayList<Integer> list){
        if(node == null)
            return;
        dfsInorder(node.left, list);
        list.add(node.value);
        dfsInorder(node.right, list);
        System.out.println(Arrays.toString(list.toArray()));

    }
    
    public boolean hasPath(TreeNode root, int val, ArrayList<Integer> path){
        if (root == null) {
            return false;
        }
        path.add(root.value);
        if (root.value == val)
            return true;
        System.out.println(Arrays.toString(path.toArray()));
        if (hasPath(root.left, val, path) ||
                hasPath(root.right, val, path))
            return true;
        
        path.remove(path.size()-1);
        return false;
        
    }
    public boolean isValidBST(TreeNode root){
        if (root == null)
            return true;
        if(root.left != null && root.left.value > root.value )
            return false;
        if (root.right !=null &&  root.right.value <root.value)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
    
    public void printEveryNodeBFS(TreeNode root){
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
}
