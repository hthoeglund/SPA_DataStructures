//CHALLENGE 1

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 100; i++){
            list.add(rand.nextInt(10));
        }
        
        Collections.sort(list);
        //LISTS ALL POSSIBLE PAIRS IN A RANDOMIZED ARRAY LIST THAT SUM TO 10
        int i = 0;
        int i2 = list.size() - 1;
        while(i < i2){
            if(list.get(i) + list.get(i2) == 10){
                System.out.print("(" + list.get(i) + ", " + list.get(i2) + ")");
                i++;
            }
            else if(list.get(i) + list.get(i2) < 10){
                i++;
            }
            else{
                i2--;
            }
        }
    }
}
