import java.util.ArrayList;

public class MyHashSet {
    public ArrayList<MyLinkedList> myHashSet;
    private int bSize;

    public MyHashSet(int b){
        bSize = b;
        myHashSet = new ArrayList<MyLinkedList>();
    }

    public void add(int k){
        //if the bucket exists
        if(myHashSet.size() * bSize >= k){
            if(!isInSet(k)){
                //adds to correct bucket 
                //we use k-1 to make sure the last element in a bucket goes to the correct one, ex: 10/5 = 2 but 10 would go in the same bucket as 9, 8, etc.
                //integer division ensures (k-1)/bSize is an integer
                myHashSet.get((k-1)/bSize).addEnd(k);
                //if the bucket was created to facilitate larger numbered buckets (ex: if 15 is added before 5-10, and now we are adding 8), remove the placeholder
                if(myHashSet.get((k-1)/bSize).headNode.data == 0){
                    myHashSet.get((k-1)/bSize).remove(0);
                }
            }
        } 
        else{
            hash(k);
            myHashSet.get((k-1)/bSize).addEnd(k);
            myHashSet.get((k-1)/bSize).remove(0);
        }
    }

    public boolean isInSet(int k){
        //if the bucket exists, check if it is in the bucket
        if(myHashSet.size() - 1 >= (k-1)/bSize){
            Node currentNode = myHashSet.get((k-1)/bSize).headNode;
            boolean isInSet = false;
                while(currentNode != null){
                    if(currentNode.data == k){
                        isInSet = true;
                    }
                    currentNode = currentNode.next;
                }
            return isInSet;
        }
        else{
            return false;
        }
    }

    private void hash(int k){
        int numBuck = ((k-1)-myHashSet.size()*bSize)/bSize + 1;
        for(int i = 0; i < numBuck; i++){
            Node node = new Node(0);
            MyLinkedList list = new MyLinkedList(node);
            myHashSet.add(list);
        }
    }

    public String toString(){
        return myHashSet.toString();
    }
}
