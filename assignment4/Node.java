public class Node {
    public int data;
    public Node next;

    public Node(int d){
        data = d;
        next = null;
    }

    public void setLink(Node node){
        next = node;
    }
}
