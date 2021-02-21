public class TreeNode {
    public int data;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int d){
        data = d;
        right = null;
        left = null;
    }

    public void setRight(TreeNode node){
        right = node;
    }

    public void setLeft(TreeNode node){
        left = node;
    }

    public String toString(){
        return "" + data;
    }
}
