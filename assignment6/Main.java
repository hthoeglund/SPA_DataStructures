public class Main{
    public static void main(String[] args){
        //I did all three recursion problems because I wanted to and they were short

        // RECURSION 1:
        System.out.println(factorial(6));

        // RECURSION 2:
        System.out.println(palindrome("Dog"));
        System.out.println(palindrome("goog"));
        System.out.println(palindrome("Doggod"));
        System.out.println(palindrome("d"));
        System.out.println(palindrome(""));

        // RECURSION 3:
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(firstOc(a, 4));
        System.out.println(firstOc(a, 6));

        TreeNode node = new TreeNode(5);
        // BST tree = new BST(node);
        // tree.add(6);
        // System.out.println(tree);
    }

    //Returns true if the string is a palindrome. Compares first and last letters, then moves inward
    public static boolean palindrome(String s, int n){
        s = s.toLowerCase();
        //Base case: if n is in the middle of the word or has passed the middle of the word (for even lengthed words) return true
        if(n >= s.length() - 1 - n){
            return true;
        }
        //Return true if the two letters are equal, false otherwise.
        else if(s.charAt(n) == s.charAt(s.length()-1-n)){
                return palindrome(s, n+1);
        }
        else{
            return false;
        }
    }
    public static boolean palindrome(String s){
        return palindrome(s, 0);
    }

    //Returns the factorial of n.
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }

    public static int firstOc(int[] a, int n, int i){
        if(i == a.length){
            return -1;
        }
        else if (a[i] == n){
            return i;
        }
        else{
            return firstOc(a, n, i + 1);
        }
    }
    public static int firstOc(int[] a, int n){
        return firstOc(a, n, 0);
    }
}