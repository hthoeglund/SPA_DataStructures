import java.util.Random;
import java.util.ArrayList;

public class Grid {
    private ArrayList<ArrayList<Integer>> grid;
    private int gridX;
    private int gridY;
    private int wallCount;
    
    public Grid(int x, int y, int k){
        grid = new ArrayList<ArrayList<Integer>>();
        gridX = x;
        gridY = y;
        wallCount = k;
        createGrid();
    }

    //Creates the initial grid
    public void createGrid(){
        Random rand = new Random();
        //Fills the grid with 0's
        for(int i = 0; i < gridX; i++){
            ArrayList<Integer> gridList = new ArrayList<Integer>();
            for(int i2 = 0; i2 < gridY; i2++){
                gridList.add(0);
            }
            grid.add(gridList);
        }
        //Adds k walls (sets the 0 to 1)
        while(wallCount > 0){
            int x = rand.nextInt(gridX);
            int y = rand.nextInt(gridY);
            //only places a wall if the space is empty and not (0,0) (the start)
            if(grid.get(x).get(y) == 0 && (x != 0 || y != 0)){
                grid.get(x).set(y, 1);
                wallCount--;
            }
        }
    }

    public String toString(){
        String gridString = "";
        for(int i = 0; i < gridY; i++){
            for(int i2 = 0; i2 < gridX; i2++){
                gridString = gridString + "[" + grid.get(i2).get(i) + "] ";
            }
            gridString = gridString + "\n"; 
        }

        return gridString;
    }
    //Teleports the mouse
    public void changeSpot (int x, int y, Mouse m){
        m.setX(x);
        m.setY(y);
    }

    public int getXSize(){
        return gridX;
    }

    public int getYSize(){
        return gridY;
    }

    public ArrayList<ArrayList<Integer>> getGrid(){
        return grid;
    }
}
