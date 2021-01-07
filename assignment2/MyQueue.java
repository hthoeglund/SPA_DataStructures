public class MyQueue {
    private int[] arrayQ;

    public MyQueue(int[] array){
        arrayQ = array;
    }

    public void queue(int x){
        int sizeA = arrayQ.length;
        int[] newArray = new int[sizeA + 1];
        for(int i = 0; i < arrayQ.length; i++){
            newArray[i] = arrayQ[i];
        }
        newArray[sizeA] = x;

        arrayQ = newArray;
    }

    public void dequeue(){
        //O(n-1) because we need to set ever n-1 value of newArray individually
        int sizeA = arrayQ.length;
        int[] newArray = new int[sizeA - 1];
        for(int i = 1; i < arrayQ.length; i++){
            newArray[i-1] = arrayQ[i];
        }

        arrayQ = newArray;
    }

    public void printList(){
        System.out.print("(");
        for(int i = 0; i < arrayQ.length; i++){
            if(i == arrayQ.length-1){
                System.out.print(arrayQ[i]);
            }
            else{
                System.out.print(arrayQ[i] + ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }
}
