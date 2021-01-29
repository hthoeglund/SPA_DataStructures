public class Main{
    public static void main(String[] args){
        MyHashSet set = new MyHashSet(5);
        set.add(1);
        set.add(11);
        System.out.println(set);
        set.add(6);
        set.add(5);
        System.out.println(set);
        set.add(30);
        set.add (17);
        System.out.println(set);
    }
}