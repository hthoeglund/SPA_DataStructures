import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        //Create a a list with 10 numbers, loop through each item and print n + 4 (using recursion)
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        loop(list, 4, list.size() - 1);
        System.out.println(list);
    }

    public static void loop(ArrayList<Integer> list, int n, int index){
        if(index >= 0){
            list.set(index, list.get(index) + n);
            loop(list, n, index - 1);
        }
    }
}