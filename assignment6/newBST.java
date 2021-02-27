import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class newBST {
    private TreeNode headNode;

    public newBST(TreeNode node){
        headNode = node;
    }

    public newBST(){
        headNode = null;
    }

    // Recursive
    public void add(int n){
        if(headNode == null){
            headNode = new TreeNode(n);
        }
        TreeNode currentNode = headNode;
        //continues until n is in the tree
        boolean check = false;
        while(check == false){
            //if n is larger, go down right path
            if(n > currentNode.data){
                if(currentNode.right == null){
                    currentNode.right = new TreeNode(n);
                    check = true;
                }
                else{
                    currentNode = currentNode.right;
                }
            }
            //if n is smaller, go down left path
            else if(n < currentNode.data){
                if(currentNode.left == null){
                    currentNode.left = new TreeNode(n);
                    check = true;
                }
                else{
                    currentNode = currentNode.left;
                }
            }
            else{
                check = true;
            }
        }
    }

    //This print function adds the headNode to a list, and then it adds the second layer by reading the list and adding the left and right of list.get(0). It adds the third layer by adding in the left and right of each node in the second layer, etc.
    public void printBST(){
        int l = length();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int startDex = 0;
        for(int i = 0; i < l; i++){
            if(i == 0){
                list.add(headNode);
                System.out.println("{" + headNode + "}");
            }
            else{
                int l2 = list.size();
                //startDex ensures that items aren't added multiple times
                for(int i2 = startDex; i2 < l2; i2++){
                    if(list.get(i2) != null){
                        list.add(list.get(i2).left);
                        System.out.print("{" + list.get(i2).left + "} ");
                        list.add(list.get(i2).right);
                        System.out.print("{" + list.get(i2).right + "} ");
                    }
                    else{
                        list.add(null);
                        list.add(null);
                        System.out.print("{null} ");
                        System.out.print("{null} ");
                    }
                }
                startDex = l2;
                System.out.println("");
            }
        }
    }

    //returns the height of the tree
    private int length(){
        if(headNode == null){
            return 0;
        }
        else{
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            stack.push(headNode);
            int l = 1;
            TreeNode currentNode = headNode;
            while(stack.size() > 0){
                currentNode.visited = true;
                if (currentNode.right != null && !currentNode.right.visited){
                    stack.push(currentNode.right);
                    currentNode = currentNode.right;
                    if(stack.size() > l){
                        l = stack.size();
                    }
                }
                else if (currentNode.left != null && !currentNode.left.visited){
                    stack.push(currentNode.left);
                    currentNode = currentNode.left;
                    if(stack.size() > l){
                        l = stack.size();
                    }
                }
                else{
                    //Reverses in the tree
                    stack.pop();
                    if(stack.size() > 1){
                        currentNode = stack.pop();
                        stack.push(currentNode);
                    }
                    //Once back at the headNode, sets the currentNode to headNode.
                    else{
                        currentNode = headNode;  
                    }
                }
            }
            return l;
        }
    }
}
