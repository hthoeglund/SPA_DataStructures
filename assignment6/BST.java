import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.lang.Math;

public class BST {
    private TreeNode headNode;

    public BST(TreeNode node){
        headNode = node;
    }

    // public BST(){
    //     headNode = null;
    // }

    // Recursive
    // public void add(TreeNode root, int n){
    //     if(root == null){
    //         root = new TreeNode(n);
    //     }
    //     if (n > root.data){
    //             add(root.right, n);
    //     }
    //     else if (n < root.data){
    //             add(root.left, n);
    //     }
    //     else{
    //         return;
    //     }
    // }
    // public void add(int n){
    //     add(headNode, n);
    // }
    
    // Non-Recursive
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

    public String toString(){
        System.out.print("Lengthing");
        int l = length();
        System.out.print(l);
        String s = "";       
        //iterates through each layer
        for(int i = 0; i < 2*l; i++){
            //if it is a layer with nodes, adds the correct nodes of that layer
            s = s + "\n";
            if(i % 2 == 0){
                ArrayList<TreeNode> list = new ArrayList<TreeNode>(); 
                addLayer(list, i);
                for(int i2 = 0; i2 < (Math.pow(2, l-(i/2))-1); i2++){
                    s = s + " ";
                }
                    // this is the code I would use if the list contained the whole tree: s = s + "{" + list.get(2^(i/2) - 1) + "}";
                    s = s + "{" + list.get(0) + "}";
            }
            //else if it is a layer that only has "/ \")
            else {
                //the if statement ensures that the correct amount of spaces are added if length = i
                if(l-i == 0){
                    s = s + " ";
                }
                else{
                    for(int i2 = 0; i2 < Math.pow(2, l-i)+1; i2++){
                        s = s + " ";
                    }
                }
                s = s + "/";
            }
            
        }
        return s;
    }
    //adds every node in the nth layer to a list
    public void  addLayer(ArrayList<TreeNode> list, int n){
        //If it is a layer with nodes in it
        if(n % 2 == 0){
            int layerNum = n/2;
            //I made a variable here because there was a weird syntax error
            Double x = Math.pow(2, layerNum);
            while(list.size() < x){
                //I copied this section from the length() function and simply altered it so it 1) goes left to right instead of right to left, 2) adds to a list if a node is in the desired layer, and 3) no longer keeps track of length
                TreeNode currentNode = headNode;
                if(layerNum == 0){
                    list.add(currentNode);
                }
                else{
                    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
                    stack.push(headNode);
                    int layer = 0;
                    boolean left = false;
                    while(stack.size() > 0){
                        if (currentNode.left != null && left == false){
                            stack.push(currentNode.left);
                            layer++;
                            currentNode = currentNode.left;
                            if(layer == layerNum){
                                list.add(currentNode);
                            }
                        }
                        else if (currentNode.right != null){
                            stack.push(currentNode.right);
                            layer++;
                            currentNode = currentNode.right;
                            if(layer == layerNum){
                                list.add(currentNode);
                            }
                            left = false;
                        }
                        else{
                            stack.pop();
                            layer--;
                            currentNode = stack.pop();
                            stack.push(currentNode);
                            left = true;
                        }
                    }
                }
            }
        }
    }
    //returns the height of the tree
    public int length(){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(headNode);
        int l = 1;
        TreeNode currentNode = headNode;
        boolean right = false;
        while(stack.size() > 0){
            if (currentNode.right != null && right == false){
                stack.push(currentNode.right);
                currentNode = currentNode.right;
                if(stack.size() > l){
                    l = stack.size();
                }
            }
            else if (currentNode.left != null){
                stack.push(currentNode.left);
                currentNode = currentNode.left;
                if(stack.size() > l){
                    l = stack.size();
                }
                right = false;
            }
            else{
                stack.pop();
                if(stack.size() > 1){
                    currentNode = stack.pop();
                    stack.push(currentNode);
                    right = true;
                }
                else{
                    stack.pop();
                }
            }
        }
        return l;
    }
}

            // {0}
            // / \
            //
            //   {0}
            //   / \
            // {1} {2}
            //
            //       {0}
            //     /     \
            //   {1}     {2}
            //   / \     / \
            // {1} {2} {2} {1}
            //
            //               {0}
            //         /             \
            //       {1}             {2}
            //     /     \         /     \
            //   {1}     {2}     {2}     {1}
            //   / \     / \     / \     / \
            // {1} {2} {3} {4} {5} {6} {1} {2}
            //
            //                               {0}
            //                 /                             \
            //               {1}                             {2}
            //         /             \                 /             \
            //       {1}             {2}             {2}             {1}
            //     /     \         /     \         /     \         /     \
            //   {1}     {2}     {3}     {4}     {5}     {6}     {1}     {2}
            //   / \     / \     / \     / \     / \     / \     / \     / \
            // {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1} {1}
            //
            //Space counts
            //First Rows: 1, 3, 7, 15, 31 2^(length)-1
            //Second Rows: 1, 3, 5, 9, 17 2^(length-1)+1 (1, 1, 5, 12, 29)
            //Third Rows: 0, 1, 3, 7, 15  2^(length-1))-1
            //Fourth Rows: 0, 1, 3, 5, 9 2^(length-2)+1