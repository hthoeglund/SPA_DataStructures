public class MyStack {
    public int[] arrayStack;

    public MyStack(int[] array){
        arrayStack = array;
    }

    public void push(int x){
        int sizeA = arrayStack.length;
        int[] newArray = new int[sizeA + 1];
        for(int i = 0; i < arrayStack.length; i++){
            newArray[i] = arrayStack[i];
        }
        newArray[sizeA] = x;

        arrayStack = newArray;
    }

    public int pop(){
        //O(n-1) because we need to set every n-1 value of newArray individually
        int sizeA = arrayStack.length;
        int pop = arrayStack[arrayStack.length-1];
        int[] newArray = new int[sizeA - 1];
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = arrayStack[i];
        }

        arrayStack = newArray;

        return pop;
    }
    
    public void printList(){
        System.out.print("(");
        for(int i = 0; i < arrayStack.length; i++){
            if(i == arrayStack.length-1){
                System.out.print(arrayStack[i]);
            }
            else{
                System.out.print(arrayStack[i] + ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }
}
