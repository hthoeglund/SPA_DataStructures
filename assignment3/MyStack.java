import java.util.ArrayList;

public class MyStack {
    public ArrayList<ArrayList<Integer>> arrayStack;

    public MyStack(ArrayList<ArrayList<Integer>> array){
        arrayStack = array;
    }

    public MyStack(){
        arrayStack = new ArrayList<ArrayList<Integer>>();
    }

    public void push(ArrayList<Integer> pos){
        arrayStack.add(pos);
    }

    public ArrayList<Integer> pop(){
        ArrayList<Integer> p = arrayStack.get(arrayStack.size()-1);
        arrayStack.remove(arrayStack.size()-1);
        return p;
    }

    public String toString(){
        return arrayStack.toString();
    }
}