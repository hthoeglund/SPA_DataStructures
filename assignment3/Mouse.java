import java.util.*;

public class Mouse {
    private String name;
    private int xCoord;
    private int yCoord;
    private ArrayList<ArrayList<Integer>> coordinateHistoryStack;
    private MyStack stack;

    public Mouse(String iName, int iXCoord, int iYCoord){
        //Creates the variables for tracking the mouse's movement
        coordinateHistoryStack = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> coords = new ArrayList<Integer>();
        stack = new MyStack();
        //Set's the mouse's name
        name = iName;
        //Set's the mouse's position
        xCoord = iXCoord;
        yCoord = iYCoord;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }

    public String toString(){
        String info = name + " is at (" + xCoord + ", " + yCoord + "), and the history of his movement is " + coordinateHistoryStack + "\n";

        return info;
    }
    //Fills the board
    public void fill(Grid grid){
        //Scans surroundings and adds to the stack scan if there are open spaces surrounding
        fillTile(grid);
        SM(grid);
        while(stack.arrayStack.size() > 0){
            fillTile(grid);
            SM(grid);
        }
    }
    //Replaces a 0 with a 2
    public void fillTile(Grid grid){
        if(grid.getGrid().get(xCoord).get(yCoord) == 0){
            grid.getGrid().get(xCoord).set(yCoord, 2);
        }
    }
    //Checks if there are any open spaces, moves if there are
    public boolean SM(Grid grid){
        if(yCoord - 1 >= 0){
            //Checks if there is an open space above
            if(grid.getGrid().get(xCoord).get(yCoord - 1) == 0){
                stack.push(currentPos());
                moveUp();
                return true;
            }
            //Checks if there is an open space to the NorthEast
            else if(xCoord + 1 < grid.getXSize()){
                if(grid.getGrid().get(xCoord + 1).get(yCoord - 1) == 0){
                    stack.push(currentPos());
                    moveNE();
                    return true;
                }
            }
        }
        if(xCoord + 1 < grid.getXSize()){
            //Checks if there is an open space to the right
            if(grid.getGrid().get(xCoord + 1).get(yCoord) == 0){
                stack.push(currentPos());
                moveRight();
                return true;
            }
            //Checks if there is an open space to the SouthEast
            else if(yCoord + 1 < grid.getYSize()){
                if(grid.getGrid().get(xCoord + 1).get(yCoord + 1) == 0){
                    stack.push(currentPos());
                    moveSE();
                    return true;
                }
            }
        }
        if(yCoord + 1 < grid.getYSize()){
            //Checks if there is an open space below
            if(grid.getGrid().get(xCoord).get(yCoord + 1) == 0){
                stack.push(currentPos());
                moveDown();
                return true;
            }
            //Checks if there is an open space to the SouthWest
            else if (xCoord - 1 >= 0){
                if(grid.getGrid().get(xCoord - 1).get(yCoord + 1) == 0){
                    stack.push(currentPos());
                    moveSW();
                    return true;
                }
            }
        }
        if(xCoord - 1 >= 0){
            //Checks if there is an open space to the left
            if(grid.getGrid().get(xCoord - 1).get(yCoord) == 0){
                stack.push(currentPos());
                moveLeft();
                return true;
            }
            //Checks if there is an open space to the NorthWest
            else if (yCoord - 1 >= 0){
                if(grid.getGrid().get(xCoord - 1).get(yCoord - 1) == 0){
                    stack.push(currentPos());
                    moveNW();
                    return true;
                }
            }
        }
        reverse();
        return false;
    }
    //Reverses last movement
    public void reverse(){
        ArrayList<Integer> lastPos = stack.pop();
        if(xCoord > lastPos.get(0)){
            if(yCoord < lastPos.get(1)){
                moveSW();
            }
            else if (yCoord == lastPos.get(1)){
                moveLeft();
            }
            else{
                moveNW();
            }
        }
        else if(xCoord < lastPos.get(0)){
            if(yCoord < lastPos.get(1)){
                moveSE();
            }
            else if (yCoord == lastPos.get(1)){
                moveRight();
            }
            else{
                moveNE();
            }
        }
        else{
            if(yCoord < lastPos.get(1)){
                moveDown();
            }
            else if (yCoord > lastPos.get(1)){
                moveUp();
            }
        }
    }
    //The arrayList must be re-initialized every time to prevent coordinateHistoryStack from overwriting previous values.
    public void moveUp(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        yCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }

    public void moveDown(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        yCoord++;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveRight(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord++;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveLeft(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveNE(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord++;
        yCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveSE(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord++;
        yCoord++;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveSW(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord--;
        yCoord++;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }
    public void moveNW(){
        ArrayList<Integer> coords = new ArrayList<Integer>();
        xCoord--;
        yCoord--;
        coords.add(xCoord);
        coords.add(yCoord);
        coordinateHistoryStack.add(coords);
    }

    public void setX(int x){
        xCoord = x;
    }

    public void setY(int y){
        yCoord = y;
    }

    //returns the mouse's current position
    public ArrayList<Integer> currentPos(){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        pos.add(xCoord);
        pos.add(yCoord);

        return pos;
    }
}