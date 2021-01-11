public class MyList{
    private int[] myArray;

    public MyList(int[] iMyArray){
        myArray = iMyArray;
    }

    public void append(int x){
        //O(n+1) because we need to set every n+1 value of newArray individually
        int sizeA = myArray.length;
        int[] newArray = new int[sizeA + 1];
        for(int i = 0; i < myArray.length; i++){
            newArray[i] = myArray[i];
        }
        newArray[sizeA] = x;

        myArray = newArray;
    }

    public void pop(){
        //O(n-1) because we need to set every n-1 value of newArray individually
        int sizeA = myArray.length;
        int[] newArray = new int[sizeA - 1];
        for(int i = 0; i < newArray.length; i++){
            newArray[i] = myArray[i];
        }

        myArray = newArray;
    }

    public void insert(int x, int n){
        //O(n+1) because we need to set every n+1 value of newArray individually
        int sizeA = myArray.length;
        int[] newArray = new int[sizeA + 1];
        boolean check = false;
        for(int i = 0; i < newArray.length; i++){
            if(i == n){
                newArray[i] = x;
                check = true;
            }
            else if(check == false){
                newArray[i] = myArray[i];
            }
            else{
                newArray[i] = myArray[i-1];
            }
        }

        myArray = newArray;
    }

    public void remove(int n){
        //O(n-1) because we need to set every n-1 value of newArray individually
        int sizeA = myArray.length;
        int[] newArray = new int[sizeA - 1];
        boolean check = false;
        for(int i = 0; i < myArray.length; i++){
            if (i == n){
                check = true;
            }
            else if(check == false){
                newArray[i] = myArray[i];
            }
            else{
                newArray[i-1] = myArray[i];
            }
        }
        
        myArray = newArray;
    }

    public void printList(){
        System.out.print("(");
        for(int i = 0; i < myArray.length; i++){
            if(i == myArray.length-1){
                System.out.print(myArray[i]);
            }
            else{
                System.out.print(myArray[i] + ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }
}
