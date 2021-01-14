public class Main{
    public static void main(String[] args){
        Grid grid = new Grid(4, 4, 3);
        System.out.println(grid);
        Mouse RoombaCheese = new Mouse("RoombaCheese", 0, 0);
        RoombaCheese.fill(grid);
        System.out.println(RoombaCheese);
        System.out.println(grid);
    }
}