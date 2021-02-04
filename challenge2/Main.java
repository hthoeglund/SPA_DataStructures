import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println(addN(4));
    }

    //Adds n to every integer in an inputted string
    public static String addN(int n){
        Scanner console = new Scanner(System.in);
        System.out.print("What string would you like to use? ");

        String text = console.next();
        console.close();

        //converts the string into a char array
        char[] newText = text.toCharArray();
        text = "";
        
        //checks if each character is an integer, adds n if it is, and then converts back to a string
        for(int i = 0; i < newText.length; i++){
            if(Character.isDigit(newText[i])){
                int a = Character.getNumericValue(newText[i]) + n;
                text = text + a;
            }
            else{
                text = text + newText[i];
            }
        }

        return text;
    }

}
