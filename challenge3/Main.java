import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i = 0; i < 10; i++){
        //     list.add(i);
        // }
        // loop(list, 4, list.size() - 1);
        // System.out.println(list);
        System.out.println(fib(7));
    }

    //Create a a list with 10 numbers, loop through each item and print n + 4 (using recursion)
    public static void loop(ArrayList<Integer> list, int n, int index){
        if(index >= 0){
            list.set(index, list.get(index) + n);
            loop(list, n, index - 1);
        }
    }

    //returns nth fibbonacci number
    public static int fib(int n){
        if(n == 1){
            return 1;
        }
        else if (n > 1){
            return fib(n-2) + fib(n-1);
        }
        else{
            return 0;
        }
    }
}