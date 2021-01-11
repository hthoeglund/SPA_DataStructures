public class DumbQueue {
    private MyStack s;

    public DumbQueue(MyStack stack){
        s = stack;
    }

    public void queue(int x){
        //O(1) is the value if we were actually using a stack, but since we are converting an array to a stack it is O(n+1) (same reason as MyList)
        s.push(x);
    }

    public void dequeue(){
        //O(2n-1) because we need to remove every value (n) and then add back every value except the one we want to remove (n-1)
        int[] myArray = {};
        MyStack newS = new MyStack(myArray);
        while(s.arrayStack.length > 1){
            newS.push(s.pop());
        }
        s.pop();
        while(newS.arrayStack.length > 0){
            s.push(newS.pop());
        }
    }

    public void printList(){
        System.out.print("(");
        for(int i = 0; i < s.arrayStack.length; i++){
            if(i == s.arrayStack.length-1){
                System.out.print(s.arrayStack[i]);
            }
            else{
                System.out.print(s.arrayStack[i] + ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }
}
