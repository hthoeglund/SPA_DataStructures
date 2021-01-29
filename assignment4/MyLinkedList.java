public class MyLinkedList {
    public Node headNode;

    public MyLinkedList(Node n){
        headNode = n;
    }

    public String toString(){
        Node currentNode = headNode;
        String list = "";
        while(currentNode != null){
            list += currentNode.data + " ";
            currentNode = currentNode.next;
        }
        return list;
    }

    //Adds to the end of the list
    public void addEnd(int k){
        Node node = new Node(k);
        Node currentNode = headNode;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.setLink(node);
    }

    //Adds to the beginning of the list
    public void add(int k){
        Node node = new Node(k);
        node.next = headNode;
        headNode = node;
    }

    public void remove(int index){
        if(index == 0){
            headNode = headNode.next;
        }
        else{
            Node currentNode = headNode;
            //sets current node to index-1
            for(int i = 0; i < index - 1; i++){
                currentNode = currentNode.next;
            }
            //connects currentNode to currentNode.next.next
            currentNode.next = currentNode.next.next;
        }  
    }

    public void insert(int k, int index){
        Node node = new Node(k);
        Node currentNode = headNode;
        //sets current node to index-1
        for(int i = 0; i < index - 1; i++){
            currentNode = currentNode.next;
        }
        //Creates a temporary node storing the current node at index
        Node next = currentNode.next;
        //inserts the new node
        currentNode.next = node;
        //reconnects the temporary node
        node.next = next;
    }

    public void Switch(int index, int index2){
        //sets currentNode to the node before node1
        Node currentNode = headNode;
        Node node1 = null;
        Node preNode1 = null;
        if(index == 0){
            node1 = headNode;
        }
        else{
            for(int i = 0; i < index - 1; i++){
                currentNode = currentNode.next;
            }
            //sets node1 to the node at index and creates a node prior to it
            node1 = currentNode.next;
            preNode1 = currentNode;
        }
        //repeats
        currentNode = headNode;
        for(int i = 0; i < index2 - 1; i++){
            currentNode = currentNode.next;
        }
        Node node2 = currentNode.next;
        Node preNode2 = currentNode;

        //Switches them
        if(index == 0){
            headNode = node2;
            preNode2.next = node1;
            Node tempNode = node1.next;
            node1.next = node2.next;
            node2.next = tempNode;
        }
        else{
            preNode1.next = node2;
            preNode2.next = node1;
            Node tempNode = node1.next;
            node1.next = node2.next;
            node2.next = tempNode;
        }
    }

    public void reverse(){
        Node currentNode = headNode;
        Node tempNode = null;
        while(currentNode.next != null){
            Node tempNode2 = currentNode.next;
            currentNode.next = tempNode;
            tempNode = currentNode;
            currentNode = tempNode2;
        }
            currentNode.next = tempNode;
            headNode = currentNode;
        
    }
        
    public Node lastNode(){
        Node currentNode = headNode;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        
        return currentNode;
    }
}
