public class TreeNode {
    public int data;
    public TreeNode right;
    public TreeNode left;
    public boolean visited;

    public TreeNode(int d){
        data = d;
        right = null;
        left = null;
        visited = false;
    }

    public String toString(){
        return "" + data;
    }
}
